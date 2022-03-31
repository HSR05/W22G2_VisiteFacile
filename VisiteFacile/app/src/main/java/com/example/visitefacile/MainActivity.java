package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.visitefacile.Database.DestinationDatabase;
import com.example.visitefacile.adapter.Destination;
import com.example.visitefacile.adapter.RecentsAdapter;
import com.example.visitefacile.adapter.TopPlacesAdapter;
import com.example.visitefacile.model.RecentsData;
import com.example.visitefacile.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tname;
    RecyclerView recentRecycler,topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonViewCities = findViewById(R.id.buttonViewCities);
        tname = findViewById(R.id.txtViewName);
        String name = getIntent().getStringExtra("name");
        tname.setText(name);

        buttonViewCities.setOnClickListener((View view) ->{

        startActivity(new Intent(MainActivity.this,TopCitiesActivity.class));

        });
        //Database read
        //True false
        //Database records read --> Store in list
        //Object arraylist --> List<Destination>

        DestinationDatabase db = Room.databaseBuilder(getApplicationContext(),
                DestinationDatabase.class, "DestinationDatabase.db").build();

        List<Destination> recentsDataList = new ArrayList<>();
//        recentsDataList.add(new RecentsData("Alimatha Island","Maldives","From 900$",R.drawable.maldives));
//        recentsDataList.add(new RecentsData("Taj Mahal","India","From 700$",R.drawable.india));
//        recentsDataList.add(new RecentsData("Rincón de la Vieja","Costa Rica","From 600$",R.drawable.costarica));
//        recentsDataList.add(new RecentsData("Sugar Loaf","Brazil","From 800$",R.drawable.brazil));

        /*ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                DestinationDao.insertDestination(recentsDataList);
                //db.DestinationDao().UpdateNumOfTickets(recentsDataList.get(i).getDestinationName());
            }
        }); */
        //setRecentRecycler(recentsDataList);

        List<Destination> topPlacesDataList = new ArrayList<>();
//        topPlacesDataList.add(new TopPlacesData("Bern","Switzerland","$2200 - $3500",R.drawable.bern));
//        topPlacesDataList.add(new TopPlacesData("Stanley Park","Canada","$400 - $900",R.drawable.stanleypark));
//        topPlacesDataList.add(new TopPlacesData("Taj Mahal","India","$900 - $1200",R.drawable.india));
//        topPlacesDataList.add(new TopPlacesData("Rincón de la Vieja","Costa Rica","$1600 - $2100",R.drawable.costarica));

        //setTopPlacesRecycler(topPlacesDataList);
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList){

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this,recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this,topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }

}