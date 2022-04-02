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

    List<TravelImage> tavelImage =  new ArrayList<>();
    List<Destination> myDestinationList = new ArrayList<>();
    GridView gridViewDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);

//        myDestinationList = ReadAuctionCSV();
//        Log.d("DBDEMO","Entered: "+myDestinationList.size() );
//        gridViewDestination = findViewById(R.id.gridViewTravel);
//
//        DestinationAdapter myDestinationAdapter =new DestinationAdapter(myDestinationList);
//        gridViewDestination.setAdapter(myDestinationAdapter);
//        gridViewDestination.setNumColumns(2);
//        gridViewDestination.setHorizontalSpacing(8);
//        gridViewDestination.setVerticalSpacing(8);
//
//        DestinationDatabase db = Room.databaseBuilder(getApplicationContext(),DestinationDatabase.class, "destinationevents.db").build();
//
//    }
//
//    private List<Destination> ReadAuctionCSV() {
//        List<Destination> DestinationList = new ArrayList<>();
//        InputStream inputStream = getResources().openRawResource(R.raw.destination);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//        try{
//            String csvDestinationLine = reader.readLine(); //Reading out the header
//
//            while((csvDestinationLine=reader.readLine())!=null){
//                String[] eachDestinationLine = csvDestinationLine.split(",");
//                String destinationPicName = eachDestinationLine[1];
//                int destinationDrawable =getResources().getIdentifier(destinationPicName, "drawable", getPackageName());
//
//                double destinationPrice = Double.parseDouble(eachDestinationLine[3]);
//
//                boolean destinationStatus;
//
//                //Keeping the fact that if it is not no, it is going to be yes
//                if(eachDestinationLine[4].equals("no")){
//                    destinationStatus = false;
//                } else{
//                    destinationStatus = true;
//                }
//
//                //Creating the object here
//                Destination eachDestination = new Destination(eachDestinationLine[0],eachDestinationLine[1],destinationDrawable,eachDestinationLine[2],destinationPrice,destinationStatus);
//
//                //Grade eachGrade = new Grade(eachGradeLine[0], eachGradeLine[1], grade);
//                DestinationList.add(eachDestination);
//            }
//
//
//        }catch (IOException ex){
//            throw new RuntimeException("Error Reading the csv file: "+ex);
//        } finally {
//            try{
//                inputStream.close();
//            } catch (IOException ex){
//                throw new RuntimeException("Error closing the csv file");
//            }
//        }
//
//    return DestinationList;
          }

    }
