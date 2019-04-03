package com.example.gimnasdual.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gimnasdual.R;
import com.example.gimnasdual.RVAdapters.RVesdeveniments;
import com.example.gimnasdual.model.Esdeveniment;

import java.util.ArrayList;
import java.util.List;

public class EsdevenimentsFragment extends Fragment {

    View rootView;
    List<Esdeveniment> esdevenimentList;
    RecyclerView rv;

    public EsdevenimentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_esdeveniments, container, false);
        rv = rootView.findViewById(R.id.rv_esdeveniments);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        initData();
        initAdapter();
        return rootView;
    }

    private void initAdapter() {
        RVesdeveniments adapter = new RVesdeveniments(esdevenimentList, R.id.rv_esdeveniments, R.id.cv_targeta_name, R.id.cv_targeta_image);
        rv.setAdapter(adapter);
    }

    private void initData() {
        esdevenimentList = new ArrayList<>();
        esdevenimentList.add(new Esdeveniment(1, "Esdeveniment1", "Hola", "Hola", "Hola", "Hola", R.drawable.ic_menu_black_24dp));
        esdevenimentList.add(new Esdeveniment(2, "Esdeveniment2", "Hola", "Hola", "Hola", "Hola", R.drawable.ic_menu_black_24dp));
        esdevenimentList.add(new Esdeveniment(3, "Esdeveniment3", "Hola", "Hola", "Hola", "Hola", R.drawable.ic_menu_black_24dp));
    }
}
