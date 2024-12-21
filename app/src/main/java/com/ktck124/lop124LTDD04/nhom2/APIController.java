package com.ktck124.lop124LTDD04.nhom2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIController {
    private static final String BASE_URL = "http://192.168.1.4:82/CuoiKi/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
//        Gson gson = new GsonBuilder().setLenient().create();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}