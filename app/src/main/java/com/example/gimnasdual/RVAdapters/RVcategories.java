package com.example.gimnasdual.RVAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gimnasdual.AsyncTask.DownloadTask;
import com.example.gimnasdual.Interfaces.ICategoriesInterface;
import com.example.gimnasdual.R;
import com.example.gimnasdual.data.ResponseCategoriaActivitat;

import java.util.List;

public class RVcategories extends RecyclerView.Adapter<TargetaViewHolder> {

    List<ResponseCategoriaActivitat> categoriaList;
    long cardView_id, textView_id, imageView_id;
    ICategoriesInterface iCategoriesInterface;
    private DownloadTask mMyTask;
    private ImageView[] imatges = new ImageView[categoriaList.size()];

    public RVcategories(List<ResponseCategoriaActivitat> list, int cardView_id, int textView_id, int imageView_id, ICategoriesInterface iCategoriesInterface
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
        mosViewHolder.mLogo.setImageResource(Integer.parseInt(categoriaList.get(i).getImage()));
        mosViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                iCategoriesInterface.sendCategoryId((int) categoriaList.get(position).getId());
            }
        });
    }
    public void LoadImage() {
        mMyTask = new DownloadTask(imatges);
        mMyTask.execute();

    }
}
