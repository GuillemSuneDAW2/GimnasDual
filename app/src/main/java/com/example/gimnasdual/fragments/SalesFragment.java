package com.example.gimnasdual.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gimnasdual.R;
import com.example.gimnasdual.RVAdapters.RVsales;
import com.example.gimnasdual.model.*;

import java.util.ArrayList;
import java.util.List;

public class SalesFragment extends Fragment {

    View rootView;
    List<Sala> salaList;
    RecyclerView rv;

    public SalesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sales, container, false);
        rv = rootView.findViewById(R.id.rv_sales);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        initData();
        initAdapter();
        return rootView;
    }

    private void initAdapter() {
        RVsales adapter = new RVsales(salaList, R.id.rv_sales, R.id.cv_targeta_name, R.id.cv_targeta_image);
        rv.setAdapter(adapter);
    }

    private void initData() {
        salaList = new ArrayList<>();
        salaList.add(new Sala(1, "Sala1", "S1", 50, "Descr1", R.drawable.ic_menu_black_24dp));
        salaList.add(new Sala(2, "Sala2", "S2", 30, "Descr2", R.drawable.ic_menu_black_24dp));
        salaList.add(new Sala(3, "Piscina1", "P1", 25, "Descr3", R.drawable.ic_menu_black_24dp));
    }
}
