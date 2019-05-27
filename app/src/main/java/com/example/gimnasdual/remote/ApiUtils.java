package com.example.gimnasdual.remote;

public class ApiUtils {

    private ApiUtils() {}

    //public static final String BASE_URL = "http://192.168.56.1:53102/";
    public static final String BASE_URL = "http://172.16.12.17:53102/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
