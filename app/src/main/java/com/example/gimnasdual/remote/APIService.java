package com.example.gimnasdual.remote;

import com.example.gimnasdual.data.ResponseDiaNoHabil;

import retrofit2.Call;
import retrofit2.http.GET;

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


}
