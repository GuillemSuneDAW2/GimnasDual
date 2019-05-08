package com.example.gimnasdual.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gimnasdual.Interfaces.ICategoriesInterface;
import com.example.gimnasdual.R;
import com.example.gimnasdual.RVAdapters.RVcategories;
import com.example.gimnasdual.data.ResponseCategoriaActivitat;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesFragment extends Fragment {

    View rootView;
    List<ResponseCategoriaActivitat> categoriaList;
    RecyclerView rv;

    private APIService mAPIService;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_categories, container, false);
        rv = rootView.findViewById(R.id.rv_categories);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));

        mAPIService = ApiUtils.getAPIService();


        initData();
        initAdapter();

        return rootView;
    }

    private void initAdapter() {
        RVcategories adapter = new RVcategories(categoriaList, R.id.rv_categories, R.id.cv_targeta_name, R.id.cv_targeta_image, new ICategoriesInterface() {
            @Override
            public void sendCategoryId(int categoryId) {
                Toast.makeText(getContext(), ""+categoryId, Toast.LENGTH_SHORT).show();
            }
        });
        rv.setAdapter(adapter);
    }

    private void initData() {
        getCategories();
    }


    public void getCategories () {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getActCateg()
                .enqueue(new Callback<List<ResponseCategoriaActivitat>>() {
                    //Si la connexió no s'ha perdut i la comunicació ha estat correcte.
                    //Entra a l'onResponse encara que torni un codi de no haver trobat res.

                    @Override
                    public void onResponse(Call<List<ResponseCategoriaActivitat>> call, Response<List<ResponseCategoriaActivitat>> response) {
                        if (response.isSuccessful() && response.body().size() > 0) {
                            List<ResponseCategoriaActivitat> myListCategories = response.body();
                        }
                    }
                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseCategoriaActivitat>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext().getApplicationContext(), "no va", Toast.LENGTH_SHORT).show();
                    }

                    });
    }
}
