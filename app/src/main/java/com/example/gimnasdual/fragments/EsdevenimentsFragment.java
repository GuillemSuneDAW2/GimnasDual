package com.example.gimnasdual.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gimnasdual.Interfaces.ICategoriesInterface;
import com.example.gimnasdual.R;
import com.example.gimnasdual.RVAdapters.RVesdeveniments;
import com.example.gimnasdual.data.ResponseEsdeveniment;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EsdevenimentsFragment extends Fragment {

    View rootView;
    List<ResponseEsdeveniment> esdevenimentList;
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
        getEsdeveniments();
        return rootView;
    }

    private void initAdapter() {
        RVesdeveniments adapter =
                new RVesdeveniments(esdevenimentList, R.id.rv_esdeveniments, R.id.cv_targeta_name, R.id.image_ActCateg, new ICategoriesInterface() {
            @Override
            public void sendCategoryId(int categoryId) {
                Fragment newFragment = EsdevenimentsInfoFragment.newInstance();

                Bundle arguments = new Bundle();
                arguments.putString( "id" , String.valueOf(categoryId));
                newFragment.setArguments(arguments);

                FragmentTransaction frgTransition = getFragmentManager().beginTransaction();
                frgTransition.replace(R.id.content_frame, newFragment, String.valueOf(categoryId)).addToBackStack("esdevenimentsInfo");
                frgTransition.commit();
            }
        });
        rv.setAdapter(adapter);
    }
    public void getEsdeveniments () {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getEsdevenimentTot()
                .enqueue(new Callback<List<ResponseEsdeveniment>>() {
                    //Si la connexió no s'ha perdut i la comunicació ha estat correcte.
                    //Entra a l'onResponse encara que torni un codi de no haver trobat res.

                    @Override
                    public void onResponse(Call<List<ResponseEsdeveniment>> call, Response<List<ResponseEsdeveniment>> response) {
                        if (response.isSuccessful()) {
                            if(response.body().size() > 0) {
                                esdevenimentList = response.body();
                                initAdapter();
                            }
                            else {

                            }
                        }
                    }
                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseEsdeveniment>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext(), "no va", Toast.LENGTH_SHORT).show();
                    }

                });
    }
}
