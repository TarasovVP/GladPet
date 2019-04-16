package com.milestns.gladpet;

import android.content.Context;


public class ApiConfig {
    private Context context;
    private String baseUrl;

    public ApiConfig(Context context, String baseUrl) {
        this.context = context;
        this.baseUrl = baseUrl;
    }

     Context getContext() {
        return context;
    }

     void setContext(Context context) {
        this.context = context;
    }

     String getBaseUrl() {
        return baseUrl;
    }

     void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
