package com.example.visitefacile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visitefacile.Database.DestinationDao;
import com.example.visitefacile.Database.DestinationDatabase;
import com.example.visitefacile.adapter.Destination;
import com.example.visitefacile.adapter.RecentsAdapter;
import com.example.visitefacile.adapter.TopPlacesAdapter;
import com.example.visitefacile.model.RecentsData;
import com.example.visitefacile.model.TopPlacesData;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextView tname;
    RecyclerView recentRecycler,topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;
    List<Destination> recentsDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tname = findViewById(R.id.txtViewName);
        String name = getIntent().getStringExtra("name");
        tname.setText(name);

        TextView MySeeAll = findViewById(R.id.textViewSeeAll);

        MySeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SeeAllActivity.class));
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
                        Toast.makeText(MainActivity.this, "Clicked on Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.favorite:
                        //user
                        Toast.makeText(MainActivity.this, "Clicked on Favorites", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,FavActivity.class));
                        break;

                    case R.id.rating:
                        //rating
                        Toast.makeText(MainActivity.this, "Clicked on Rating", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(MainActivity.this,RatingActivity.class));
                        break;

                    case R.id.cities:
                        //cities
                        Toast.makeText(MainActivity.this, "Clicked on Cities", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,TopCitiesActivity.class));
                        break;

                }
                return false;
            }
        });


        //Database read
        //True false
        //Database records read --> Store in list
        //Object arraylist --> List<Destination>



        recentsDataList = ReadDestinationCSV();


        DestinationDatabase myDb  = Room.databaseBuilder(getApplicationContext(), DestinationDatabase.class, "destinations.db").build();

        DestinationDao destinationDao = myDb.destinationDao();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //destinationDao.GetAllDestinationData();
                destinationDao.insertDestination(recentsDataList);
            }
        });


        /*ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                DestinationDao.insertDestination(recentsDataList);
                //db.DestinationDao().UpdateNumOfTickets(recentsDataList.get(i).getDestinationName());
            }
        }); */
        setRecentRecycler(recentsDataList);

        List<Destination> topPlacesDataList = new ArrayList<>();
        for(int i=0; i<recentsDataList.size(); i++){
            if(recentsDataList.get(i).isDestinationStatus()==true){
                topPlacesDataList.add(recentsDataList.get(i));
            }
        }

//        topPlacesDataList.add(new TopPlacesData("Bern","Switzerland","$2200 - $3500",R.drawable.bern));
//        topPlacesDataList.add(new TopPlacesData("Stanley Park","Canada","$400 - $900",R.drawable.stanleypark));
//        topPlacesDataList.add(new TopPlacesData("Taj Mahal","India","$900 - $1200",R.drawable.india));
//        topPlacesDataList.add(new TopPlacesData("Rincón de la Vieja","Costa Rica","$1600 - $2100",R.drawable.costarica));

        setTopPlacesRecycler(topPlacesDataList);
    }



    private void setRecentRecycler(List<Destination> recentsDataList){

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this,recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private void setTopPlacesRecycler(List<Destination> topPlacesDataList){

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this,topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }

    private List<Destination> ReadDestinationCSV(){

        List<Destination> DestinationList = new ArrayList<>();



        InputStream inputStream = getResources().openRawResource(R.raw.destination);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));


        try{
            String csvDestinationLine = reader.readLine(); //Reading out the header

            while((csvDestinationLine=reader.readLine())!=null){
                String[] eachDestinationLine = csvDestinationLine.split(",");
                String destinationPicName = eachDestinationLine[2];
                int destinationDrawable =getResources().getIdentifier(destinationPicName, "drawable", getPackageName());

                double destPrice = Double.parseDouble(eachDestinationLine[6]);

                boolean topDestStatus;

                //Keeping the fact that if it is not no, it is going to be yes
                if(eachDestinationLine[5].equals("no")){
                    topDestStatus = false;
                } else{
                    topDestStatus = true;
                }

                //Creating the object here
                Destination eachDestination = new Destination(eachDestinationLine[0],eachDestinationLine[1],destinationDrawable,eachDestinationLine[3], destPrice,topDestStatus,eachDestinationLine[7]);

                DestinationList.add(eachDestination);
            }


        }catch (IOException ex){
            throw new RuntimeException("Error Reading the csv file: "+ex);
        } finally {
            try{
                inputStream.close();
            } catch (IOException ex){
                throw new RuntimeException("Error closing the csv file");
            }
        }



        return DestinationList;
    }



}