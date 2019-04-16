package com.milestns.gladpet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    List<Pets> listPets;
    RecyclerView recyclerView;
    RecycleViewAdapter adapter;
    View rootView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate( R.layout.activity_home, container, false );

        ApiNetworkService.getService().getAllpets()
                .enqueue(new Callback<List<Pets>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Pets>> call, @NonNull Response<List<Pets>> response) {

                        listPets = response.body();
                        recyclerView = (RecyclerView) rootView.findViewById( R.id.recycle_view );
                        adapter = new RecycleViewAdapter( getContext(), listPets);
                        final GridLayoutManager layoutManager = new GridLayoutManager( getActivity(), 1, GridLayoutManager.HORIZONTAL, false );
                        recyclerView.setLayoutManager( layoutManager );
                        recyclerView.setAdapter( adapter );
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Pets>> call, @NonNull Throwable t) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });



        return rootView;

    }
}
