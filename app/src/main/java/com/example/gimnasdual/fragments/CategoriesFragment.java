package com.example.gimnasdual.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gimnasdual.Interfaces.ICategoriesInterface;
import com.example.gimnasdual.R;
import com.example.gimnasdual.RVAdapters.RVcategories;
import com.example.gimnasdual.model.*;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {

    View rootView;
    List<Categoria> categoriaList;
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
        categoriaList = new ArrayList<>();
        categoriaList.add(new Categoria(77, "Categ1", R.drawable.ic_menu_black_24dp));
        categoriaList.add(new Categoria(89, "Categ2", R.drawable.ic_menu_black_24dp));
        categoriaList.add(new Categoria(103, "Categ3", R.drawable.ic_menu_black_24dp));
    }


    /*
    private void initData() {
        categoriaList = new ArrayList<>();
        mAPIService.registerEmployee(name, job).enqueue(new Callback<ResponseRegister>() {
            // When there's response, even if it is an error
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, R.string.registre_ok, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "No s'ha afegit", Toast.LENGTH_SHORT).show();
                }
            }
            // When the connection fails
            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Can't connect", Toast.LENGTH_SHORT).show();
            }
        });
    }
    */
}
