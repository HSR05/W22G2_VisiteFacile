package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {

    private static int Splash_timer = 6000;

    ImageView backgroundImage;
    TextView txtViewMadeBy, txtViewTitle;


    Animation sideAnim, bottomUpAnim, fadeAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        backgroundImage = findViewById(R.id.background_image);
        txtViewMadeBy = findViewById(R.id.txtViewMadeby);
        txtViewTitle = findViewById(R.id.txtViewTitle);

        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomUpAnim = AnimationUtils.loadAnimation(this,R.anim.bottomup_anim);
        fadeAnim = AnimationUtils.loadAnimation(this,R.anim.fade_in_anim);

        backgroundImage.setAnimation(fadeAnim);
        txtViewTitle.setAnimation(sideAnim);
        txtViewMadeBy.setAnimation(bottomUpAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Splash_Screen.this, MainActivity2.class);
                startActivity(intent);

            }
        }, Splash_timer);

    }
}