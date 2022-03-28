package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageView imageView = findViewById(R.id.imageView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle b = getIntent().getExtras();
        int image = b.getInt("image");
        imageView.setImageResource(image);
        String placeName = getIntent().getExtras().getString("placeName");
        String countryName = getIntent().getExtras().getString("countryName");
        String price = getIntent().getExtras().getString("price");

        TextView txtView2 = findViewById(R.id.textView2); //country and place name
        TextView textView5 = findViewById(R.id.textView5); // price
        String outputstring = placeName +", "+countryName;
        txtView2.setText(outputstring);

        textView5.setText(price);
    }

}