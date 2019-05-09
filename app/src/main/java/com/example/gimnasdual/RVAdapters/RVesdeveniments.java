package com.example.gimnasdual.RVAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gimnasdual.R;
import com.example.gimnasdual.data.ResponseEsdeveniment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVesdeveniments extends RecyclerView.Adapter<TargetaViewHolder> {

    List<ResponseEsdeveniment> esdevenimentList;
    int cardView_id, textView_id, imageView_id;
    public RVesdeveniments(List<ResponseEsdeveniment> list, int cardView_id, int textView_id, int imageView_id) {
        this.esdevenimentList = list;
        this.cardView_id = cardView_id;
        this.textView_id = textView_id;
        this.imageView_id = imageView_id;
    }

    @Override
    public int getItemCount() {
        return esdevenimentList.size();
    }

    @Override
    public TargetaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_targeta, viewGroup, false);
        TargetaViewHolder pvh = new TargetaViewHolder(v, cardView_id, textView_id, imageView_id);
        return pvh;
    }

    @Override
    public void onBindViewHolder(TargetaViewHolder mosViewHolder, int i) {
        mosViewHolder.mName.setText(esdevenimentList.get(i).getTitol());
        Picasso.get().load(esdevenimentList.get(i).getImage()).into(mosViewHolder.mLogo);
    }
}
