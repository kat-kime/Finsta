package com.katexcellence.finsta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.katexcellence.finsta.fragments.ComposeFragment;
import com.katexcellence.finsta.fragments.HomeFragment;
import com.katexcellence.finsta.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_navigation);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        final Fragment homeFragment = new HomeFragment();
        final Fragment composeFragment = new ComposeFragment();
        final Fragment profileFragment = new ProfileFragment();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;

                switch (menuItem.getItemId()) {
                    // TODO: Create a profile fragment
                    case R.id.action_profile:
                        fragment = profileFragment;
                        Toast.makeText(MainActivity.this, "Profile selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_create:
                        fragment = composeFragment;
                        Toast.makeText(MainActivity.this, "Create selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_home:
                    default:
                        fragment = homeFragment;
                        Toast.makeText(MainActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });

        // Set default selection
        bottomNavigation.setSelectedItemId(R.id.action_home);


    }


}