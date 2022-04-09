package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.visitefacile.Database.DestinationDao;
import com.example.visitefacile.Database.DestinationDatabase;
import com.example.visitefacile.adapter.Destination;
import com.example.visitefacile.adapter.DestinationAdapter;
import com.example.visitefacile.adapter.SeeAllAdapter;
import com.example.visitefacile.adapter.TravelImage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SeeAllActivity extends AppCompatActivity {


    List<Destination> myDestinationList = new ArrayList<>();
    ListView myNewListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);
        myNewListView = findViewById(R.id.listViewItems);

        DestinationDatabase myDb  = Room.databaseBuilder(getApplicationContext(), DestinationDatabase.class, "destinations.db").build();

        DestinationDao destinationDao = myDb.destinationDao();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                myDestinationList = myDb.destinationDao().GetAllDestinationData();
                SeeAllAdapter newSeeAllAdapter = new SeeAllAdapter(myDestinationList);
                myNewListView.setAdapter(newSeeAllAdapter);

            }
        });

        myNewListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle myBundle = new Bundle();

                Intent myIntent = new Intent(SeeAllActivity.this, DetailsActivity.class);
                startActivity(myIntent.putExtra("DBINDEX", myDestinationList
                        .get(i)
                        .getDestinationName()));

            }
        });


          }

    }
