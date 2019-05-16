package com.example.gimnasdual.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gimnasdual.ListViewAdapters.ListDiaAdapter;
import com.example.gimnasdual.R;
import com.example.gimnasdual.model.FirebaseWorkout.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class RutinaFragment extends Fragment {

    View rootView;

    ListView mDates;
    Button btn_add;

    ListDiaAdapter listDiaAdapter;

    String nomSoci;
    String sociKey;
    Soci soci;
    List<Dia> dies;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mWorkoutReference;

    public RutinaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_rutina, container, false);

        FirebaseApp.initializeApp(getContext());
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mWorkoutReference = mFirebaseDatabase.getReference().child("socis");

        getSociNom();
        LoadViews();
        LoadSoci(nomSoci);

        return rootView;
    }

    private void LoadAdapter(String key, Soci s) {
        sociKey = key;
        soci = s;
        dies = soci.getDies();
        if (dies != null){
            listDiaAdapter = new ListDiaAdapter(getContext(), android.R.layout.activity_list_item, dies);
            mDates.setAdapter(listDiaAdapter);
        } else {
            Toast.makeText(getContext(), "No tens cap entrenament registrat", Toast.LENGTH_SHORT).show();
        }
    }

    private void LoadSoci(String nomSoci){
        Query query = mWorkoutReference.orderByChild("nom").equalTo(nomSoci);
        query.addValueEventListener(valueEventListener);
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()){
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Soci soci = snapshot.getValue(Soci.class);
                    LoadAdapter(snapshot.getKey(),soci);
                }
            } else {
                Soci nouSoci = new Soci(nomSoci);
                mWorkoutReference.push().setValue(nouSoci);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(getContext(), "No s'ha pogut obtenir les dades", Toast.LENGTH_SHORT).show();
        }
    };

    public void getSociNom(){
        Context context = getContext();

        SharedPreferences sharedPref = context.getSharedPreferences("KEY", Context.MODE_PRIVATE);
        nomSoci = sharedPref.getString("2", "");
    }

    private void LoadViews() {

        btn_add = rootView.findViewById(R.id.btn_addDay);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                Fragment fragment = new Rutina2Fragment();

                Bundle bundle = new Bundle();
                bundle.putString("sociKey", sociKey);
                bundle.putSerializable("soci", soci);
                bundle.putInt("dia", -1);

                fragment.setArguments(bundle);

                ft.replace(R.id.content_frame, fragment).addToBackStack("dayWorkout")
                        .commit();
            }
        });

        mDates = rootView.findViewById(R.id.workout_lv_dates);
        mDates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                Fragment fragment = new Rutina2Fragment();

                Bundle bundle = new Bundle();
                bundle.putString("sociKey", sociKey);
                bundle.putSerializable("soci", soci);
                bundle.putInt("dia", position);

                fragment.setArguments(bundle);

                ft.replace(R.id.content_frame, fragment).addToBackStack("dayWorkout")
                        .commit();
            }
        });
    }
}
