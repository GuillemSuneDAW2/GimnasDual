package com.example.gimnasdual.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gimnasdual.R;
import com.example.gimnasdual.RVAdapters.RVcategories;
import com.example.gimnasdual.model.*;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {

    View rootView;
    List<Categoria> categoriaList;
    RecyclerView rv;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_categories, container, false);
        rv = rootView.findViewById(R.id.rv_categories);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        initData();
        initAdapter();
        return rootView;
    }

    private void initAdapter() {
        RVcategories adapter = new RVcategories(categoriaList, R.id.rv_categories, R.id.cv_targeta_name, R.id.cv_targeta_image);
        rv.setAdapter(adapter);
    }

    private void initData() {
        categoriaList = new ArrayList<>();
        categoriaList.add(new Categoria(1, "Categ1", R.drawable.ic_menu_black_24dp));
        categoriaList.add(new Categoria(2, "Categ2", R.drawable.ic_menu_black_24dp));
        categoriaList.add(new Categoria(3, "Categ3", R.drawable.ic_menu_black_24dp));
    }
}
