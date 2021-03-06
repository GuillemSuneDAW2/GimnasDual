package com.example.gimnasdual.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.gimnasdual.R;
import com.example.gimnasdual.RVAdapters.MessageAdapter;
import com.example.gimnasdual.model.ChatMessage;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {
    private static final String TAG = "MainActivity";

    public static  String ANONYMOUS = "anonymous";
    public static final int DEFAULT_MSG_LENGTH_LIMIT = 1000;

    private ListView mMessageListView;
    private MessageAdapter mMessageAdapter;
    private EditText mMessageEditText;
    private Button mSendButton;

    private String mUsername;

    private FirebaseDatabase mFirebaseDatabase;

    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListener ;

    public ChatFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        getSavedMessage();
        mUsername = ANONYMOUS;
        FirebaseApp.initializeApp(inflater.getContext());
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("messages");

        mMessageListView = (ListView) view.findViewById(R.id.messageListView);
        mMessageEditText = (EditText) view.findViewById(R.id.messageEditText);
        mSendButton = (Button) view.findViewById(R.id.sendButton);

        List<ChatMessage> friendlyMessages = new ArrayList<>();
        mMessageAdapter = new MessageAdapter(getContext(), R.layout.item_message, friendlyMessages);
        mMessageListView.setAdapter(mMessageAdapter);

        mMessageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() > 0) {
                    mSendButton.setEnabled(true);
                } else {
                    mSendButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        mMessageEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creem una instància del nostre POJO i l'afegim el text introduit pel layout.
                ChatMessage friendlyMessage = new ChatMessage(mMessageEditText.getText().toString(), mUsername);


                //Afegim el missatge a la BBDD
                //mMessagesDatabaseReference.setValue(friendlyMessage);
                mMessagesDatabaseReference.push().setValue(friendlyMessage);



                // Clear input box
                mMessageEditText.setText("");
            }
        });
        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //Passem per par`metre perquè deserialitzi el Pojo.
                ChatMessage friendlyMessage = dataSnapshot.getValue(ChatMessage.class);
                mMessageAdapter.add(friendlyMessage);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };


        mMessagesDatabaseReference.addChildEventListener(mChildEventListener);

        // Inflate the layout for this fragment
        return view;
    }
    public void getSavedMessage(){
        Context context = getContext();

        SharedPreferences sharedPref = context.getSharedPreferences("KEY", Context.MODE_PRIVATE);
        String lastMessage = sharedPref.getString("2", "");

        if (!lastMessage.equals("")){
            ANONYMOUS = lastMessage;
        }
    }
}
