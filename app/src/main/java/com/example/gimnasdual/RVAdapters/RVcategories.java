package com.example.gimnasdual.RVAdapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gimnasdual.Interfaces.ICategoriesInterface;
import com.example.gimnasdual.R;
import com.example.gimnasdual.data.ResponseCategoriaActivitat;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RVcategories extends RecyclerView.Adapter<TargetaViewHolder> {

    List<ResponseCategoriaActivitat> categoriaList;
    int cardView_id, textView_id, imageView_id;
    ICategoriesInterface iCategoriesInterface;
    private ImageView[] imatges; // = new ImageView[categoriaList.size()];

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
        Picasso.with(mosViewHolder.mLogo.getContext())
                .load((categoriaList.get(i).getImage()))
                .into(mosViewHolder.mLogo);
        mosViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iCategoriesInterface.sendCategoryId((int) categoriaList.get(position).getId());
            }
        });
    }
    public void getListCategory () {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getActCateg()
                .enqueue(new Callback<List<ResponseCategoriaActivitat>>() {
                    //Si la connexió no s'ha perdut i la comunicació ha estat correcte.
                    //Entra a l'onResponse encara que torni un codi de no haver trobat res.

                    @Override
                    public void onResponse(Call<List<ResponseCategoriaActivitat>> call, Response<List<ResponseCategoriaActivitat>> response) {
                        if (response.isSuccessful()) {
                            if(response.body().size() > 0) {
                                categoriaList = response.body();
                            }
                            else {
                            }
                        }
                    }
                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseCategoriaActivitat>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                    }
                });
    }
}
