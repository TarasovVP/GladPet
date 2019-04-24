package com.milestns.gladpet.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    @BindView(R.id.sexPet)
    ImageView sexPet;
    @BindView(R.id.agePet)
    TextView agePet;
    @BindView(R.id.sexTextPet)
    TextView sexTextPet;
    @BindView(R.id.heightPet)
    TextView heightPet;
    @BindView(R.id.chipPet)
    TextView chipPet;
    @BindView(R.id.vaccinatePet)
    TextView vaccinatePet;
    @BindView(R.id.swallowedPet)
    TextView swallowedPet;
    @BindView(R.id.infoPet)
    TextView infoPet;
    @BindView(R.id.characterPetInfo)
    TextView characterPetInfo;
    @BindView(R.id.behaviorPetInfo)
    TextView behaviorPetInfo;
    @BindView(R.id.wishPetInfo)
    TextView wishPetInfo;
    @BindView(R.id.imageView2)
    ImageView imageView2;
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
        Picasso.with(getContext()).load(pet.getAvatar()).into(avatarPet);
        namePet.setText( pet.getName() );
        cityPet.setText( pet.getLocation() );
        breedPet.setText( String.valueOf( pet.getBreed() ) );

        sexTextPet.setText( pet.getName() );
        agePet.setText( pet.getAge() );
        heightPet.setText( pet.getSize() );

       /* chipPet.setText( pet.getName() );
        vaccinatePet.setText( pet.getName() );
        swallowedPet.setText( pet.getName() );
*/
        infoPet.setText( pet.getHistory() );
        characterPetInfo.setText( pet.getNature() );
        behaviorPetInfo.setText( pet.getBehavior() );
        wishPetInfo.setText( pet.getWishes() );

        phonedPet.setText( pet.getName() );
        mailPet.setText( pet.getName() );
        viberPet.setText( pet.getName() );
        addressPet.setText( pet.getName() );
    }

}
