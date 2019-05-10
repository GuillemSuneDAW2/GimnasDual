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

import com.example.gimnasdual.R;
import com.example.gimnasdual.RVAdapters.RVsales;
import com.example.gimnasdual.data.ResponseSala;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalesFragment extends Fragment {

    View rootView;
    List<ResponseSala> salaList;
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
        getSales();
        return rootView;
    }

    private void initAdapter() {
        RVsales adapter = new RVsales(salaList, R.id.rv_sales, R.id.cv_targeta_name, R.id.image_ActCateg);
        rv.setAdapter(adapter);
    }
    public void getSales () {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getSalaTot()
                .enqueue(new Callback<List<ResponseSala>>() {
                    //Si la connexió no s'ha perdut i la comunicació ha estat correcte.
                    //Entra a l'onResponse encara que torni un codi de no haver trobat res.

                    @Override
                    public void onResponse(Call<List<ResponseSala>> call, Response<List<ResponseSala>> response) {
                        if (response.isSuccessful()) {
                            if(response.body().size() > 0) {
                                salaList = response.body();
                                initAdapter();
                            }
                            else {

                            }
                        }
                    }
                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseSala>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext(), "no va", Toast.LENGTH_SHORT).show();
                    }

                });
    }

}
