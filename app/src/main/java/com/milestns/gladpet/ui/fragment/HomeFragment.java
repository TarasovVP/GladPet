package com.milestns.gladpet.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.milestns.gladpet.R;
import com.milestns.gladpet.model.Pets;
import com.milestns.gladpet.ui.adapter.RecycleViewAdapter;

import java.util.List;


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
        Bundle args = getArguments();
        if (args != null) {
             listPets = args.getParcelableArrayList("listPets");

        }
        adapter = new RecycleViewAdapter( getActivity(), listPets );
        final GridLayoutManager layoutManager = new GridLayoutManager( getActivity(), 2, GridLayoutManager.VERTICAL, false );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter( adapter );

    }


}
