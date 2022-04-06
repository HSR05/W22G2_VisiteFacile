package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class PopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        TextView textViewDisplayRating = findViewById(R.id.textViewDisplayRating);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        Bundle b=getIntent().getExtras();
        String totalstars= getIntent().getExtras().getString("totalstars");
        String rating= getIntent().getExtras().getString("rating");

        String output = "Total Stars " +totalstars +"\n"+ "Your Rating "+rating +"\n";
        textViewDisplayRating.setText(output);
    }
}