package com.milestns.gladpet;

import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    List<Pets> listPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                ApiNetworkService.getService().loadPets()
                        .enqueue(new Callback<ListPets>() {
                            @Override
                            public void onResponse(@NonNull Call<ListPets> call, @NonNull Response<ListPets> response) {

                                Intent intent = new Intent( getApplicationContext(), MainActivity.class );
                                Bundle extras = new Bundle();

                                if (response.body() != null) {
                                    listPets = response.body().getListPets();
                                    extras.putParcelableArrayList( "listPets", (ArrayList<Pets>) listPets );
                                    intent.putExtra( "bundle", extras );
                                    startActivity( intent );
                                    finish();

                                }
                            }
                            @Override
                            public void onFailure(@NonNull Call<ListPets> call, @NonNull Throwable t) {
                                Toast.makeText(getApplicationContext(), R.string.error, Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        }, 3000);
    }
}
