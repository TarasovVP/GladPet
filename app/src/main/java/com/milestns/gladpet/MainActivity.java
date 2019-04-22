package com.milestns.gladpet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    List<Pets> listPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Bundle extras = intent.getBundleExtra("bundle");
        if (extras != null) {
            listPets =  extras.getParcelableArrayList("listPets");        }

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("listPets", (ArrayList<Pets>) listPets);
        Fragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, homeFragment).addToBackStack(null).commit();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.home:
                fragment = new HomeFragment();
                break;
            case R.id.favourite:
                fragment = new FavouriteFragment();
                break;
            case R.id.adopte:
                fragment = new ShelterFragment();
                break;
            case R.id.help:
                fragment = new HelpFragment();
                break;
            case R.id.chat:
                fragment = new MessageFragment();
               break;
        }
        return loadFragment(fragment);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.action_map:
                fragment = new MapFragment();
                break;
            case R.id.action_sos:
                fragment = new InfoFragment();
                break;
            case R.id.action_faq:
                fragment = new MessageFragment();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return loadFragment(fragment);
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

