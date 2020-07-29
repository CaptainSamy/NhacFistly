package com.example.nhac_fistly.Service;

public class APIService {
    private static String base_url = "https://nhacmp3vip.000webhostapp.com/api_appnhac/"; // link server
    public static  Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
