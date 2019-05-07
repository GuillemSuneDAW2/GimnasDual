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

    TargetaViewHolder(View itemView, long cv_id, long tv_id, long iv_id){
        super(itemView);
        cv = itemView.findViewById((int) cv_id);
        mName = itemView.findViewById((int) tv_id);
        mLogo = itemView.findViewById((int) iv_id);
    }
}
