package com.milestns.gladpet.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.milestns.gladpet.R;
import com.milestns.gladpet.api.ApiNetworkService;
import com.milestns.gladpet.model.ListPets;
import com.milestns.gladpet.model.Pets;

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


        ApiNetworkService.getService().loadPets()
                .enqueue( new Callback<ListPets>() {
                    @Override
                    public void onResponse(@NonNull Call<ListPets> call, @NonNull Response<ListPets> response) {

                        Intent intent = new Intent( getApplicationContext(), MainActivity.class );
                        Bundle extras = new Bundle();

                        if (response.body() != null) {
                            listPets = response.body().getListPets();
                            extras.putParcelableArrayList( "listPets", (ArrayList<Pets>) getFirstEightPets( listPets ) );
                            intent.putExtra( "bundle", extras );
                            startActivity( intent );
                            finish();

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ListPets> call, @NonNull Throwable t) {
                        Toast.makeText( getApplicationContext(), R.string.error, Toast.LENGTH_SHORT ).show();
                    }
                } );
    }
    public List<Pets>getFirstEightPets(List<Pets> firstPetsList){
        List<Pets> firstPets = new ArrayList<>(  );
        for (int i = 0; i < 8; i++) {
            firstPets.add( firstPetsList.get( i ) );
        }return firstPets;
    }
}
