package com.example.gimnasdual.RVAdapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TargetaViewHolder extends RecyclerView.ViewHolder {
    CardView cv;
    TextView mName;
    ImageView mLogo;

    TargetaViewHolder(View itemView, int cv_id, int tv_id, int iv_id){
        super(itemView);
        cv = itemView.findViewById(cv_id);
        mName = itemView.findViewById(tv_id);
        mLogo = itemView.findViewById(iv_id);
    }
}
