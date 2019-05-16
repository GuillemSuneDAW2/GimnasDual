package com.example.gimnasdual.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gimnasdual.R;
import com.example.gimnasdual.data.ResponseEsdeveniment;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EsdevenimentsInfoFragment extends Fragment {

    View rootView;
    String stringRebut;
    TextView lloc, nom, tipus, data;
    TextView desc;
    ImageView image;

    public EsdevenimentsInfoFragment() {
        // Required empty public constructor
    }

    public static EsdevenimentsInfoFragment newInstance() {
        return new EsdevenimentsInfoFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        stringRebut = arguments.getString("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_esdeveniments_info, container, false);

        nom = rootView.findViewById(R.id.tv_Nom);
        lloc = rootView.findViewById(R.id.tv_Lloc);
        tipus = rootView.findViewById(R.id.tv_Tipus);
        data = rootView.findViewById(R.id.tv_Data);
        desc = rootView.findViewById(R.id.tv_desc);
        image = rootView.findViewById(R.id.imageEsdev);

        getEsdeveniments();

        return rootView;
    }
    public void getEsdeveniments() {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getEsdeveniment(Integer.parseInt(stringRebut))
                .enqueue(new Callback<List<ResponseEsdeveniment>>() {
                    @Override
                    public void onResponse(Call<List<ResponseEsdeveniment>> call, Response<List<ResponseEsdeveniment>> response) {
                        if (response.isSuccessful()) {
                            if (response.body().size() > 0) {
                                nom.setText(response.body().get(0).getTitol());
                                lloc.setText(response.body().get(0).getLloc());
                                tipus.setText(response.body().get(0).getTipus());
                                Picasso.get().load(response.body().get(0).getImage()).into(image);
                                data.setText(response.body().get(0).getData());
                                desc.setText(response.body().get(0).getDescripcio());
                            } else {

                            }
                        }
                    }

                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseEsdeveniment>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext(), "Conexió interrumpida", Toast.LENGTH_SHORT).show();
                    }

                });
    }
}
