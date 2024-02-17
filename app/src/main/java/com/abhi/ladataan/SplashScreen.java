package com.abhi.ladataan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMER = 2000;
    ImageView imageView;
    Animation slideAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        setContentView(R.layout.splash_screen);

        imageView = findViewById(R.id.splash_logo);
        slideAnim = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom);
        imageView.setAnimation(slideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent intent = new Intent(SplashScreen.this, Map.class);
                    startActivity(intent);
                    finish();
            }
        }, SPLASH_TIMER);


    }
}