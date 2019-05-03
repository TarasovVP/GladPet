package com.milestns.gladpet.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.milestns.gladpet.R;
import com.milestns.gladpet.model.Pets;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PetFragment extends Fragment {

    @BindView(R.id.avatarPet)
    ImageView avatarPet;
    @BindView(R.id.namePet)
    TextView namePet;
    @BindView(R.id.shelterPet)
    TextView shelterPet;
    @BindView(R.id.cityPet)
    TextView cityPet;
    @BindView(R.id.breedPet)
    TextView breedPet;
    @BindView(R.id.agePet)
    TextView agePet;
    @BindView(R.id.sexPetMale)
    ImageView sexPetMale;
    @BindView(R.id.sexPetFemale)
    ImageView sexPetFemale;
    @BindView(R.id.heightPet)
    TextView heightPet;
    @BindView(R.id.sterialisedPet)
    LinearLayout sterialisedPet;
    @BindView(R.id.vaccinatedPet)
    LinearLayout vaccinatedPet;
    @BindView(R.id.underProtectedPet)
    TextView underProtectedPet;
    @BindView(R.id.featuredPet)
    TextView featuredPet;
    @BindView(R.id.characterPetInfo)
    TextView characterPetInfo;
    @BindView(R.id.behaviorPetInfo)
    TextView behaviorPetInfo;
    @BindView(R.id.wishPetInfo)
    TextView wishPetInfo;
    @BindView(R.id.allPhotos)
    ImageView allPhotos;
    @BindView(R.id.phonedPet)
    TextView phonedPet;
    @BindView(R.id.mailPet)
    TextView mailPet;
    @BindView(R.id.viberPet)
    TextView viberPet;
    @BindView(R.id.addressPet)
    TextView addressPet;

    Pets pet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.activity_pet, null );
        ButterKnife.bind( this, view );
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        Bundle args = getArguments();
        if (args != null) {
            pet = args.getParcelable( "petsList" );

        }
        Picasso.with( getContext() ).load( pet.getAvatarUrl() ).into( avatarPet );
        namePet.setText( pet.getName() );
        cityPet.setText( pet.getLocation() );

        if (pet.getSex().equalsIgnoreCase( "Мальчик" )) {
            sexPetMale.setVisibility( View.VISIBLE );
        }else if(pet.getSex().equalsIgnoreCase( "Девочка" )){
            sexPetFemale.setVisibility( View.VISIBLE );
        }
        agePet.setText( pet.getAge() );
        heightPet.setText( pet.getSize() );

        if (pet.isSterilized()) {
            sterialisedPet.setVisibility( View.VISIBLE );
        }
        if (pet.isVaccinated()) {
            vaccinatedPet.setVisibility( View.VISIBLE );
        }
        if (pet.isUnderProtection()) {
            underProtectedPet.setVisibility( View.VISIBLE );
        }
        if (pet.isFeatured()) {
            featuredPet.setVisibility( View.VISIBLE );
        }


        characterPetInfo.setText( pet.getNature() );
        behaviorPetInfo.setText( pet.getBehavior() );
        wishPetInfo.setText( pet.getWishes() );

        Picasso.with( getContext() ).load( pet.getAvatarUrl() ).into( allPhotos );

    }

}
