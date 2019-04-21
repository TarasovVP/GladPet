package com.milestns.gladpet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


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
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycle_view);

        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadPets();

    }

    public void loadPets(){
        ApiNetworkService.getService().loadPets()
                .enqueue(new Callback<ListPets>() {
                    @Override
                    public void onResponse(@NonNull Call<ListPets> call, @NonNull Response<ListPets> response) {

                        listPets = response.body().getListPets();
                        adapter = new RecycleViewAdapter( getActivity(), listPets );
                        final GridLayoutManager layoutManager = new GridLayoutManager( getActivity(), 2, GridLayoutManager.VERTICAL, false );
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter( adapter );
                    }

                    @Override
                    public void onFailure(@NonNull Call<ListPets> call, @NonNull Throwable t) {
                        Toast.makeText(getActivity(), R.string.error, Toast.LENGTH_SHORT).show();
                    }
                });


    }

}
