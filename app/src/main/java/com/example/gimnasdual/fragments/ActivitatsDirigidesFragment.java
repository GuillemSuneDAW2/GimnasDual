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
import com.example.gimnasdual.RVAdapters.RVActivitats;
import com.example.gimnasdual.data.ResponseActivitatDirigida;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitatsDirigidesFragment extends Fragment {

    View rootView;
    List<ResponseActivitatDirigida> activitatList;
    RecyclerView rv;
    String stringRebut = "";

    public ActivitatsDirigidesFragment() {

    }

    public static ActivitatsDirigidesFragment newInstance() {
        return new ActivitatsDirigidesFragment();
    }

    private APIService mAPIService;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_activitats_dirigides, container, false);


        try {
            Bundle arguments = getArguments();
            stringRebut = arguments.getString("id");
        } catch (Exception ex) {
            Log.d(ex.toString(), "exception");
        }

        rv = rootView.findViewById(R.id.rv_activitatsDirigides);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));

        mAPIService = ApiUtils.getAPIService();

        if (!stringRebut.equals("")) {
            Toast.makeText(getContext(), stringRebut, Toast.LENGTH_SHORT).show();
            getActDirigidesByCateg();
        } else {
            getActDirigides();
        }

        return rootView;
    }

    private void initAdapter() {
        RVActivitats adapter = new RVActivitats(activitatList, R.id.rv_categories, R.id.cv_targeta_name, R.id.image_categoria, new ICategoriesInterface() {
            @Override
            public void sendCategoryId(int categoryId) {
                Toast.makeText(getContext(), "" + categoryId, Toast.LENGTH_SHORT).show();
            }
        });

        rv.setAdapter(adapter);
    }

    public void getActDirigides() {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getActivitatDirigidaTot()
                .enqueue(new Callback<List<ResponseActivitatDirigida>>() {
                    @Override
                    public void onResponse(Call<List<ResponseActivitatDirigida>> call, Response<List<ResponseActivitatDirigida>> response) {
                        if (response.isSuccessful()) {
                            if (response.body().size() > 0) {
                                activitatList = response.body();
                                initAdapter();
                            } else {

                            }
                        }
                    }

                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseActivitatDirigida>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext(), "no va", Toast.LENGTH_SHORT).show();
                    }

                });
    }
    public void getActDirigidesByCateg() {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getActivitatDirigidaCateg(Integer.parseInt(stringRebut))
                .enqueue(new Callback<List<ResponseActivitatDirigida>>() {
                    @Override
                    public void onResponse(Call<List<ResponseActivitatDirigida>> call, Response<List<ResponseActivitatDirigida>> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getContext(), "funciona?", Toast.LENGTH_SHORT).show();
                            if (response.body().size() > 0) {
                                Toast.makeText(getContext(), String.valueOf(response.body().size()), Toast.LENGTH_SHORT).show();
                                activitatList = response.body();
                                initAdapter();
                            } else {

                            }
                        }
                    }

                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseActivitatDirigida>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext(), "no va 2 ", Toast.LENGTH_SHORT).show();
                    }

                });
    }
}

