package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    private HomeFragment homeFragment;
    private ProductFragment productFragment;
    private MessageFragment messageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeFragment(new HomeFragment());

        homeFragment = new HomeFragment();
        productFragment = new ProductFragment();
        messageFragment = new MessageFragment();

        bottomNavigationView  = findViewById(R.id.bottmnavigation);
        frameLayout = findViewById(R.id.framelayout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        InitializeFragment(homeFragment);
                        return true;

                    case R.id.products:
                        InitializeFragment(productFragment);
                        return true;

                    case R.id.message:
                        InitializeFragment(messageFragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void InitializeFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}