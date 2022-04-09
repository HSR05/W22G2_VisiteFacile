package com.example.visitefacile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        // initiate rating bar and a button
        final RatingBar appRatingBar = (RatingBar) findViewById(R.id.appRatingBar);
        Button submitButton = (Button) findViewById(R.id.submitButton);
        // perform click event on button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get values and then pass in a bundle
                String totalStars = ":"+appRatingBar.getNumStars();
                String rating = ":" + appRatingBar.getRating();
                //Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
                Intent popactivity = new Intent(RatingActivity.this,PopActivity.class);
                Bundle b = new Bundle();
                b.putString("totalstars",totalStars);
                b.putString("rating",rating);
                popactivity.putExtras(b);
                startActivity(popactivity);
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
                        Toast.makeText(RatingActivity.this, "Clicked on Home", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RatingActivity.this,MainActivity.class));
                        break;

                    case R.id.favorite:
                        //user
                        Toast.makeText(RatingActivity.this, "Clicked on Favorites", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RatingActivity.this,FavActivity.class));
                        break;
                    case R.id.cities:
                        //cities
                        Toast.makeText(RatingActivity.this, "Clicked on Cities", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RatingActivity.this,TopCitiesActivity.class));
                        break;


                }
                return false;
            }
        });
    }
}