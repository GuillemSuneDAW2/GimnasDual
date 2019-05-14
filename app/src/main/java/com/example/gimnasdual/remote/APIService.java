package com.example.gimnasdual.remote;

import com.example.gimnasdual.data.ResponseActivitatDirigida;
import com.example.gimnasdual.data.ResponseCategoriaActivitat;
import com.example.gimnasdual.data.ResponseDiaNoHabil;
import com.example.gimnasdual.data.ResponseDies;
import com.example.gimnasdual.data.ResponseEsdeveniment;
import com.example.gimnasdual.data.ResponseInscripcions;
import com.example.gimnasdual.data.ResponseSala;
import com.example.gimnasdual.data.ResponseSessioDia;
import com.example.gimnasdual.data.ResponseSessios;
import com.example.gimnasdual.data.ResponseSoci;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @GET("api/diaNoHabilsTot")
    Call<List<ResponseDiaNoHabil>> getDiesNoHabils();

    @GET("api/diasAndroid")
    Call<List<ResponseDies>> getDiesAndroid();

    @POST("api/inscripcioAndroid")
    Call<List<ResponseInscripcions>> postNewInscription(@Field("Soci_Id") int Soci_Id,
                                                        @Field("Sessio_Id") int Sessio_Id);

    @GET("api/sessiosDia")
    Call<List<ResponseSessioDia>> getSessioDia(@Query("dia") String dia);

    @GET("api/sessiosTot")
    Call<List<ResponseSessios>> getSessios();

    @GET("api/activitatDirigidasCategoriaAndroid?")
    Call<List<ResponseActivitatDirigida>> getActivitatDirigidaCateg(@Query("id") int id);

    @GET("api/activitatDirigidasAndroid")
    Call<List<ResponseActivitatDirigida>> getActivitatDirigidaTot();

    @GET("api/activitatDirigidaAndroid?")
    Call<List<ResponseActivitatDirigida>> getActivitatDirigida(@Query("id") int id);

    @GET("api/salasAndroid")
    Call<List<ResponseSala>> getSalaTot();

    @GET("api/salaAndroid?")
    Call<List<ResponseSala>> getSala(@Query("id") int id);

    @GET("api/categoriaActivitatsAndroid")
    Call<List<ResponseCategoriaActivitat>> getActCateg();

    @GET("api/esdevenimentsTot")
    Call<List<ResponseEsdeveniment>> getEsdevenimentTot();

    @GET("api/esdevenimentAndroid?")
    Call<List<ResponseEsdeveniment>> getEsdeveniment(@Query("id") int id);

    @GET("api/inscripcionsAndroid")
    Call<List<ResponseInscripcions>> getInscripcio(@Field("id") int id);

    @GET("api/sociAndroid")
    Call<List<ResponseSoci>> doLoginSocis(@Query("email") String email,
                                          @Query("dni") String dni);
}
