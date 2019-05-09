package com.example.gimnasdual.RVAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gimnasdual.Interfaces.ICategoriesInterface;
import com.example.gimnasdual.R;
import com.example.gimnasdual.data.ResponseActivitatDirigida;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVActivitats extends RecyclerView.Adapter<TargetaViewHolder>{
    List<ResponseActivitatDirigida> activitatList;
    int cardView_id, textView_id, imageView_id;
    ICategoriesInterface iCategoriesInterface;

    public RVActivitats(List<ResponseActivitatDirigida> activitatList, int cardView_id, int textView_id, int imageView_id, ICategoriesInterface iCategoriesInterface) {
        this.activitatList = activitatList;
        this.cardView_id = cardView_id;
        this.textView_id = textView_id;
        this.imageView_id = imageView_id;
        this.iCategoriesInterface = iCategoriesInterface;
    }

    @Override
    public int getItemCount() {
        return activitatList.size();
    }

    @Override
    public TargetaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_targeta, viewGroup, false);
        TargetaViewHolder pvh = new TargetaViewHolder(v, cardView_id, textView_id, imageView_id);
        return pvh;
    }

    int position;

    @Override
    public void onBindViewHolder(TargetaViewHolder mosViewHolder, final int i) {
        position = i;
        mosViewHolder.mName.setText(activitatList.get(i).getNom());
        Picasso.get()
                .load((activitatList.get(i).getImage()))
                .into(mosViewHolder.mLogo);
        mosViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iCategoriesInterface.sendCategoryId((int) activitatList.get(i).getId());
            }
        });
    }
}