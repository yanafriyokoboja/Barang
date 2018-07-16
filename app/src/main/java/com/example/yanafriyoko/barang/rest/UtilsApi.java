package com.example.yanafriyoko.barang.rest;

public class UtilsApi {
    // 10.0.2.2 ini adalah localhost.
    public static final String BASE_URL_API = "http://api.kodingindonesia.id/index.php/";

    // Mendeklarasikan Interface BaseApiService
    public static ApiInterface getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiInterface.class);
    }
}
