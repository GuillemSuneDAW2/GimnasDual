package com.example.gimnasdual.remote;

import com.example.gimnasdual.data.ResponseActivitatDirigida;
import com.example.gimnasdual.data.ResponseCategoriaActivitat;
import com.example.gimnasdual.data.ResponseDiaNoHabil;
import com.example.gimnasdual.data.ResponseEsdeveniment;
import com.example.gimnasdual.data.ResponseInscripcions;
import com.example.gimnasdual.data.ResponseSala;
import com.example.gimnasdual.data.ResponseSessios;
import com.example.gimnasdual.data.ResponseSoci;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    /*
    @FormUrlEncoded
    @POST("api/users")
    Call<ResponseRegister> registerEmployee(@Field("name") String name,
                                            @Field("job") String job);

    @GET("api/users")
    Call<ResponseClients> getClients(@Query("page") String page);
     */
    @GET("api/diaNoHabilsTot")
    Call<ResponseDiaNoHabil> getDiesNoHabils();

    @GET("api/sessiosTot")
    Call<List<ResponseSessios>> getSessios();

    @GET("api/activitatDirigidasAndroid")
    Call<ResponseActivitatDirigida> getActivitatDirigidaCateg(@Field("id") int id);

    @GET("api/activitatDirigidasAndroid")
    Call<ResponseActivitatDirigida> getActivitatDirigidaTot();

    @GET("api/activitatDirigidasAndroid")
    Call<ResponseActivitatDirigida> getActivitatDirigida(@Field("id") int id);

    @GET("api/salasAndroid")
    Call<ResponseSala> getSalaTot();

    @GET("api/salasAndroid")
    Call<ResponseSala> getSala(@Field("id") int id);

    @GET("api/categoriaActivitatAndroid")
    Call<ResponseCategoriaActivitat> getActCateg();

    @GET("api/esdevenimentsTot")
    Call<ResponseEsdeveniment> getEsdevenimentTot();

    @GET("api/esdevenimentsTot")
    Call<ResponseEsdeveniment> getEsdeveniment(@Field("id") int id);

    @GET("api/inscripcionsAndroid")
    Call<ResponseInscripcions> getInscripcio(@Field("id") int id);

    @GET("api/sociAndroid")
    Call<List<ResponseSoci>> doLoginSocis(@Query("email") String email,
                                          @Query("dni") String dni);


}
