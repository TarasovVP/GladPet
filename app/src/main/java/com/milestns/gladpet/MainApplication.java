package com.milestns.gladpet;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.milestns.gladpet.api.ApiConfig;
import com.milestns.gladpet.api.ApiNetworkService;

public class MainApplication extends Application {

    final static String BASE_URL = "https://gladpet.org";

    @Override
    public void onCreate() {
        super.onCreate();

        createService();
    }

    private void createService() {
        ApiConfig apiConfig = new ApiConfig(this, getString(R.string.url_base));
        ApiNetworkService.getInstance().init(apiConfig);
    }


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo;
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }
}
