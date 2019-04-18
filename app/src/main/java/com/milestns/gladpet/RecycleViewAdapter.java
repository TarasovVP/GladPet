package com.milestns.gladpet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private static final String AVATARS = "https://avatars.io/twitter/";

    private static List<Pets> petsList;

    private LayoutInflater mInflater;

    static class ViewHolder extends RecyclerView.ViewHolder {

        private Context mContext;

        @BindView(R.id.name)
        TextView userName;
        @BindView(R.id.city)
        TextView email;
        @BindView(R.id.male_age_growth)
        TextView maleAgeGrowth;
        @BindView(R.id.avatar)
        ImageView avatar;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                }
            });
        }
    }

    RecycleViewAdapter(Context context, List<Pets> petsList) {
        this.mInflater = (LayoutInflater) LayoutInflater.from( context);
        RecycleViewAdapter.petsList = petsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.pets_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        String name = petsList.get(position).getName();
        holder.userName.setText(name);
        String email = petsList.get(position).getEmail();
        holder.email.setText(email);
        String catchPhrase = petsList.get(position).getWebsite();
        holder.maleAgeGrowth.setText(catchPhrase);
        Picasso.with(context).load(getAvatars(position)).into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        return petsList.size();
    }

    private String getAvatars(Integer id) {
        return AVATARS + id;
    }

}

