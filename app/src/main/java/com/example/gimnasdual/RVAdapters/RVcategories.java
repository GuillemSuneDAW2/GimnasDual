package com.example.gimnasdual.RVAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gimnasdual.Interfaces.ICategoriesInterface;
import com.example.gimnasdual.R;
import com.example.gimnasdual.model.*;

import java.util.List;

public class RVcategories extends RecyclerView.Adapter<TargetaViewHolder> {

    List<Categoria> categoriaList;
    int cardView_id, textView_id, imageView_id;
    ICategoriesInterface iCategoriesInterface;

    public RVcategories(List<Categoria> list, int cardView_id, int textView_id, int imageView_id, ICategoriesInterface iCategoriesInterface
    ) {
        this.categoriaList = list;
        this.cardView_id = cardView_id;
        this.textView_id = textView_id;
        this.imageView_id = imageView_id;
        this.iCategoriesInterface = iCategoriesInterface;
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

    int position;
    @Override
    public void onBindViewHolder(TargetaViewHolder mosViewHolder, int i) {
        position = i;
        mosViewHolder.mName.setText(categoriaList.get(i).getNom());
        mosViewHolder.mLogo.setImageResource(categoriaList.get(i).getImage());
        mosViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                iCategoriesInterface.sendCategoryId(categoriaList.get(position).getId());
            }
        });
    }
}
