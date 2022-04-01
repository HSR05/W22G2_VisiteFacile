package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class TopCitiesActivity extends AppCompatActivity
{
    String city;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_cities);
        Spinner spinnerCityNames = findViewById(R.id.spinnerCityNames);
        TextView textViewFunFact = findViewById(R.id.textViewFunFact);
        ImageView imageViewCity = findViewById(R.id.imageViewCity);

        spinnerCityNames.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                if(i==0)
                {
                    city= "Paris";
                    textViewFunFact.setText("Did you know there is one dog for every 7 Parisians?");
                    imageViewCity.setImageResource(R.drawable.paris);

                }
                if(i==1)
                {
                    city= "London";
                    textViewFunFact.setText("Big Ben is not actually called Big Ben");
                    imageViewCity.setImageResource(R.drawable.london);
                }
                if(i==2)
                {
                    city= "Dubai";
                    textViewFunFact.setText("In Dubai Robots Are Replacing Illegal Child Labor in Camel Racing");
                    imageViewCity.setImageResource(R.drawable.dubai);
                }
                if(i==3)
            {
                city= "Tokyo";
                textViewFunFact.setText("Tokyo was originally named Edo.");
                imageViewCity.setImageResource(R.drawable.tokyo);
            }
                if(i==4)
            {
                city= "Amsterdam";
                textViewFunFact.setText("The city stands on 11 million poles.");
                imageViewCity.setImageResource(R.drawable.amsterdam);
            }




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });


    }
}