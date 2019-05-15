package com.example.gimnasdual.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gimnasdual.R;
import com.example.gimnasdual.data.ResponseDies;
import com.example.gimnasdual.data.ResponseInscripcions;
import com.example.gimnasdual.data.ResponseSessioDia;
import com.example.gimnasdual.model.Inscripcio;
import com.example.gimnasdual.model.SessionsAdapter;
import com.example.gimnasdual.model.SessionsDiaAdapter;
import com.example.gimnasdual.remote.APIService;
import com.example.gimnasdual.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SessionsFragment extends Fragment {

    View rootView;
    ListView lvSessions;
    Spinner spinnSessions;
    List<ResponseDies> listDies;
    List<ResponseSessioDia> listSessioDia;
    List<ResponseInscripcions> listInscripcio;
    String textSeleccionat;
    int idSoci, idSessio;
    SessionsDiaAdapter spinnAdapter;
    Inscripcio ins = new Inscripcio(idSessio, idSoci);

    public SessionsFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_sessions, container, false);
        lvSessions = rootView.findViewById(R.id.lvSessions);
        spinnSessions = rootView.findViewById(R.id.spinnerDias);
        getDies();
        spinnSessions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textSeleccionat = listDies.get(position).getDia();
                getSessiosPerDia();
                lvSessions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        getSavedMessage();
                        idSessio = (int) listSessioDia.get(position).getId();
                        if (idSoci != 0) {
                            crearDialog();
                        } else {
                            Toast.makeText(getContext(), "Voste no es soci!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rootView;
    }

    public void getDies() {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getDiesAndroid()
                .enqueue(new Callback<List<ResponseDies>>() {
                    @Override
                    public void onResponse(Call<List<ResponseDies>> call, Response<List<ResponseDies>> response) {
                        if (response.isSuccessful()) {
                            if (response.body().size() > 0) {
                                SessionsAdapter spinnAdapter;
                                listDies = response.body();
                                spinnAdapter = new SessionsAdapter(getContext(), android.R.layout.activity_list_item, listDies);
                                spinnSessions.setAdapter(spinnAdapter);
                            } else {

                            }
                        }
                    }

                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseDies>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext(), "no va", Toast.LENGTH_SHORT).show();
                    }

                });
    }

    public void getSessiosPerDia() {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.getSessioDia(textSeleccionat)
                .enqueue(new Callback<List<ResponseSessioDia>>() {
                    @Override
                    public void onResponse(Call<List<ResponseSessioDia>> call, Response<List<ResponseSessioDia>> response) {
                        if (response.isSuccessful()) {
                            if (response.body().size() > 0) {
                                listSessioDia = response.body();
                                spinnAdapter = new SessionsDiaAdapter(getContext(), android.R.layout.activity_list_item, listSessioDia);
                                lvSessions.setAdapter(spinnAdapter);
                            } else {

                                listSessioDia = response.body();
                                listSessioDia.clear();
                                spinnAdapter = new SessionsDiaAdapter(getContext(), android.R.layout.activity_list_item, listSessioDia);
                                lvSessions.setAdapter(spinnAdapter);
                            }
                        }
                    }

                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<List<ResponseSessioDia>> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext(), "no va", Toast.LENGTH_SHORT).show();
                    }

                });
    }

    public void crearDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Inscripció")
                .setMessage("Estas segur que et vols inscriure??")
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        getInscripcio();

                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void getInscripcio() {
        APIService mAPIService = ApiUtils.getAPIService();
        mAPIService.postNewInscription(idSoci, idSessio)
                .enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (response.isSuccessful()) {
                            if (response.body() == 0) {
                                Toast.makeText(getContext(), "Inscrit correctament", Toast.LENGTH_SHORT).show();
                            } else if (response.body() == 1) {
                                Toast.makeText(getContext(), "Ja estas inscrit", Toast.LENGTH_SHORT).show();
                            } else if (response.body() == 2) {
                                Toast.makeText(getContext(), "Ja estas inscrit a una altra sessio a la mateixa hora", Toast.LENGTH_SHORT).show();
                            } else if (response.body() == 3) {
                                Toast.makeText(getContext(), "Servei no disponible temporalment", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    // Si peta la connexió a Internet.
                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Log.d("ErrorLogResponses", t.toString());
                        Toast.makeText(getContext(), "no va", Toast.LENGTH_SHORT).show();
                    }

                });
    }

    public void getSavedMessage() {
        Context context = getContext();

        SharedPreferences sharedPref = context.getSharedPreferences("KEY", Context.MODE_PRIVATE);
        String stringRebut = sharedPref.getString("3", "");
        if (!stringRebut.equals("")) {
            idSoci = Integer.parseInt(sharedPref.getString("3", ""));
        } else {
            idSoci = 0;
        }
    }
}
