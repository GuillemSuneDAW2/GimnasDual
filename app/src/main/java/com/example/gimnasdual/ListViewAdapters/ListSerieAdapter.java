package com.example.gimnasdual.ListViewAdapters;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gimnasdual.model.FirebaseWorkout.Serie;

import java.util.List;

public class ListSerieAdapter extends ArrayAdapter<Serie> {

    private Context mContext;
    private List<Serie> mValues;

    public ListSerieAdapter(Context context, int textViewResourceId, List<Serie> objects) {
        super(context, textViewResourceId, objects);
        this.mContext = context;
        this.mValues = objects;
    }

    @Override
    public int getCount(){
        return mValues.size();
    }

    @Override
    public Serie getItem(int position){
        return mValues.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setTextSize(18);
        label.setText(position + " : Pes - " + mValues.get(position).getPes() + ", Repeticions - " + mValues.get(position).getRepeticions());
        label.setHeight(100);
        label.setGravity(Gravity.LEFT | Gravity.CENTER );
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setTextColor(Color.BLACK);
        label.setTextSize(18);
        label.setText(position + " : Pes - " + mValues.get(position).getPes() + ", Repeticions - " + mValues.get(position).getRepeticions());
        label.setHeight(100);
        label.setGravity(Gravity.LEFT | Gravity.CENTER );
        return label;
    }
}