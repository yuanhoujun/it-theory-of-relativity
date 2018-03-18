package com.youngfeng.androidclient.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitManager
 *
 * @author Scott Smith 2018-03-18 11:42
 */
public class RetrofitManager {
    private static final String BASE_URL = "http://192.168.31.146:8080";

    public static Retrofit create(String baseUrl) {
        return new Retrofit.Builder()
                          .baseUrl(baseUrl)
                          .addConverterFactory(GsonConverterFactory.create())
                          .build();
    }

    public static Retrofit createDefault() {
        return create(BASE_URL);
    }
}
