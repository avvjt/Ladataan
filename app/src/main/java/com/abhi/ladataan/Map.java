package com.abhi.ladataan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Map extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        // edited here
        getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
        setContentView(R.layout.activity_map);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.map);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.map:
                        return true;
                    case R.id.nearby:
                        Intent intent= new Intent(getApplicationContext(), Nearby.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        Intent intent1= new Intent(getApplicationContext(), Profile.class);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.timeline:
                        Intent intent2= new Intent(getApplicationContext(), Timeline.class);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;


                }



                return false;
            }
        });
    }
}