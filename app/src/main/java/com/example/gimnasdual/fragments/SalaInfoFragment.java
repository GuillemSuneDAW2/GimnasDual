package com.example.gimnasdual.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gimnasdual.R;
import com.example.gimnasdual.data.ResponseSala;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalaInfoFragment extends Fragment {

    View rootView;
    String stringRebut;
    TextView nomSala, codiSala, aforament;
    TextView descSala;
    ImageView imageSala;

    public SalaInfoFragment() {

    }

    public static SalaInfoFragment newInstance() {
       return new SalaInfoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        stringRebut = arguments.getString("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_sala_info, container, false);
        nomSala = rootView.findViewById(R.id.tv_NomSala);
        codiSala = rootView.findViewById(R.id.tv_CodiSala);
        aforament = rootView.findViewById(R.id.tv_Aformanet);
        descSala = rootView.findViewById(R.id.tv_DescSala);
        imageSala = rootView.findViewById(R.id.ivSala);

        getSalas();
        return rootView;
    }
    public void getSalas() {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getSala(Integer.parseInt(stringRebut))
                .enqueue(new Callback<List<ResponseSala>>() {
                    @Override
                    public void onResponse(Call<List<ResponseSala>> call, Response<List<ResponseSala>> response) {
                        if (response.isSuccessful()) {
                            if (response.body().size() > 0) {
                                nomSala.setText(response.body().get(0).getNom());
                                codiSala.setText(response.body().get(0).getCodi());
                                aforament.setText(String.valueOf(response.body().get(0).getAforament()));
                                Picasso.get().load(response.body().get(0).getImage()).into(imageSala);
                                descSala.setText(response.body().get(0).getDescripcio());
                            } else {

                            }
                        }
                    }

                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseSala>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext(), "Conexió interrumpida", Toast.LENGTH_SHORT).show();
                    }

                });
    }
}
