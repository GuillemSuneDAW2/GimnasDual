package com.example.gimnasdual.RVAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gimnasdual.R;
import com.example.gimnasdual.model.*;

import java.util.List;

public class RVcategories extends RecyclerView.Adapter<TargetaViewHolder> {

    List<Categoria> categoriaList;
    int cardView_id, textView_id, imageView_id;
    public RVcategories(List<Categoria> list, int cardView_id, int textView_id, int imageView_id) {
        this.categoriaList = list;
        this.cardView_id = cardView_id;
        this.textView_id = textView_id;
        this.imageView_id = imageView_id;
    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    @Override
    public TargetaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_targeta, viewGroup, false);
        TargetaViewHolder pvh = new TargetaViewHolder(v, cardView_id, textView_id, imageView_id);
        return pvh;
    }

    @Override
    public void onBindViewHolder(TargetaViewHolder mosViewHolder, int i) {
        mosViewHolder.mName.setText(categoriaList.get(i).getNom());
        mosViewHolder.mLogo.setImageResource(categoriaList.get(i).getImage());
    }
}
