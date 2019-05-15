package com.example.gimnasdual.RVAdapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gimnasdual.R;
import com.example.gimnasdual.model.ChatMessage;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<ChatMessage> {
    public MessageAdapter(Context context, int resource, List<ChatMessage> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }


        ChatMessage message = getItem(position);

        LinearLayout re = new LinearLayout(getContext());

        if(message.getName().equals(getSavedMessage())){

            re.setGravity(Gravity.RIGHT);
        }

        TextView messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);


        messageTextView.setVisibility(View.VISIBLE);
        messageTextView.setText(message.getText());
        authorTextView.setText(message.getName());

       re.addView(convertView);


        return convertView;
    }
    public String getSavedMessage() {
        Context context = getContext();

        SharedPreferences sharedPref = context.getSharedPreferences("KEY", Context.MODE_PRIVATE);
        String lastMessage = sharedPref.getString("2", "");
        return lastMessage;
    }
}
