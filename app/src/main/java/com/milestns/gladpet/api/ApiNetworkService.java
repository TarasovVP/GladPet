package com.milestns.gladpet.api;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.milestns.gladpet.R;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiNetworkService {

    private static ApiNetworkService sInstance;
    private ApiService service;
    private Context context;

    public static ApiNetworkService getInstance() {
        if (sInstance == null) {
            sInstance = new ApiNetworkService();
        }
        return sInstance;
    }

    public static ApiService getService() {
        return getInstance().service;
    }


    public void init(ApiConfig apiConfig) {
        context = apiConfig.getContext();

        OkHttpClient okHttpClient = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString( R.string.url_base))
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);

    }
}