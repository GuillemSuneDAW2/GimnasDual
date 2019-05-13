package com.example.gimnasdual.remote;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://172.16.12.25:53102/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
