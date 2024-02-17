package com.abhi.ladataan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.ScanOptions;

public class Map extends AppCompatActivity {

    FloatingActionButton floating_qr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        setContentView(R.layout.activity_map);


        Fragment fragment = new MapFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();


        floating_qr = findViewById(R.id.floating_qr);
        floating_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(Map.this);
                intentIntegrator.setPrompt("Scan QR Code");
                intentIntegrator.initiateScan();

            }
        });


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

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if (intentResult!= null){
            if (intentResult.getContents()== null){
                Toast.makeText(this, "Canceled QR Scan", Toast.LENGTH_SHORT).show();
            }else {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(intentResult.getContents())));
            }

        }else {
            super.onActivityResult(requestCode, resultCode, data);

        }
    }
*/
    public void floating_crt(View view) {
        Toast.makeText(this, "bool myLocationButtonEnabled = true;", Toast.LENGTH_SHORT).show();

    }

    public void floating_sheet(View view) {
        showSheet();
    }

    public void floating_search(View view) {
        Intent intent = new Intent(getApplicationContext(), Search.class);
        startActivity(intent);
    }

    private void showSheet() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.sheet_filters);


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.SheetAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

}