package com.example.gimnasdual.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gimnasdual.R;
import com.example.gimnasdual.data.ResponseActivitatDirigida;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitatsInfoFragment extends Fragment {

    View rootView;
    String stringRebut;
    TextView tvNom, tvTipus, tvIntensitat;
    EditText tvDesc;
    ImageView image;

    public ActivitatsInfoFragment() {

    }

    public static ActivitatsInfoFragment newInstance() {
        return new ActivitatsInfoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        stringRebut = arguments.getString("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_categories_info, container, false);
        tvNom = rootView.findViewById(R.id.tv_NomAct3);
        tvIntensitat = rootView.findViewById(R.id.tv_Intensitat);
        tvTipus = rootView.findViewById(R.id.tv_TipusAct);
        tvDesc = rootView.findViewById(R.id.tv_DescAct);
        image = rootView.findViewById(R.id.image_ActCateg);

        getActInfo();

        return rootView;
    }

    public void getActInfo() {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getActivitatDirigida(Integer.parseInt(stringRebut))
                .enqueue(new Callback<List<ResponseActivitatDirigida>>() {
                    @Override
                    public void onResponse(Call<List<ResponseActivitatDirigida>> call, Response<List<ResponseActivitatDirigida>> response) {
                        if (response.isSuccessful()) {
                            if (response.body().size() > 0) {
                                tvNom.setText(response.body().get(0).getNom());
                                tvIntensitat.setText(response.body().get(0).getIntensitat());
                                Picasso.get().load(response.body().get(0).getImage()).into(image);
                                tvTipus.setText(response.body().get(0).getTipologia());
                                tvDesc.setText(response.body().get(0).getDescripcio());
                            } else {

                            }
                        }
                    }

                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseActivitatDirigida>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext(), "Conexió interrumpida", Toast.LENGTH_SHORT).show();
                    }

                });
    }

}
