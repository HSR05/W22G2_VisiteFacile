package com.example.visitefacile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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
        Button btnViewMaps = findViewById(R.id.btnViewMaps);

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

        BottomNavigationView bottomNavigationView =(BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch(item.getItemId())
                {
                    case R.id.home:
                        //home
                        Toast.makeText(TopCitiesActivity.this, "Clicked on Home", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(TopCitiesActivity.this,MainActivity.class));
                        break;

                    case R.id.user:
                        //user
                        Toast.makeText(TopCitiesActivity.this, "Clicked on Favorites", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(TopCitiesActivity.this,FavActivity.class));
                        break;

                }
                return false;
            }
        });

        /*
        btnViewMaps.setOnClickListener((View view)->
        {
           // Intent mapact = new Intent(TopCitiesActivity.this,MapsActivity.class);
            //Bundle b = new Bundle();
           // b.putString("city",city.toString());
           // mapact.putExtras(b);
           // startActivity(mapact);


        });
        */



    }
}