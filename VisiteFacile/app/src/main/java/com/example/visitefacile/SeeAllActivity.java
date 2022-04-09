package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.example.visitefacile.Database.DestinationDatabase;
import com.example.visitefacile.adapter.Destination;
import com.example.visitefacile.adapter.DestinationAdapter;
import com.example.visitefacile.adapter.TravelImage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SeeAllActivity extends AppCompatActivity {

    List<TravelImage> travelImagesavelImage =  new ArrayList<>();
    List<Destination> myDestinationList = new ArrayList<>();
    GridView gridViewDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);


          }

    }
