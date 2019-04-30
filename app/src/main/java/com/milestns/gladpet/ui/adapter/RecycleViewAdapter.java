package com.milestns.gladpet.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.milestns.gladpet.R;
import com.milestns.gladpet.model.Pets;
import com.milestns.gladpet.ui.fragment.PetFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {


    private static List<Pets> petsList;

    private LayoutInflater mInflater;

    static class ViewHolder extends RecyclerView.ViewHolder {

        private Context mContext;

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.city)
        TextView city;
        @BindView(R.id.age)
        TextView age;
        @BindView(R.id.avatar)
        ImageView avatar;

        ViewHolder(View itemView) {
            super( itemView );
            ButterKnife.bind( this, itemView );
            mContext = itemView.getContext();

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Pets pet = petsList.get( itemPosition );
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    Fragment petFragment = new PetFragment();
                    Bundle bundle = new Bundle();
                    FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
                    bundle.putParcelable( "petsList", pet );
                    petFragment.setArguments( bundle );
                    fragmentTransaction.addToBackStack( null );
                    fragmentTransaction.replace( R.id.fragment_container, petFragment );
                    fragmentTransaction.commit();

                }
            } );
        }
    }

    public RecycleViewAdapter(Context context, List<Pets> petsList) {
        this.mInflater = (LayoutInflater) LayoutInflater.from( context );
        RecycleViewAdapter.petsList = petsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate( R.layout.pets_list, parent, false );
        return new ViewHolder( view );
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        String name = petsList.get( position ).getName();
        holder.name.setText( name );
        String city = petsList.get( position ).getLocation();
        holder.city.setText( city );
        String age = petsList.get( position ).getAge();
        holder.age.setText( age );
        Picasso.with( context ).load( petsList.get( position ).getAvatarUrl() ).into( holder.avatar );

    }

    @Override
    public int getItemCount() {
        return 8;
    }


}

