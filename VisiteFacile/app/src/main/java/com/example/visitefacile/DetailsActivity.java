package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.visitefacile.Database.DestinationDao;
import com.example.visitefacile.Database.DestinationDatabase;
import com.example.visitefacile.adapter.Destination;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DetailsActivity extends AppCompatActivity {

    Destination myDest = new Destination();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ImageView myDestImage  = findViewById(R.id.imgDestinationDetail);
        TextView myCityName = findViewById(R.id.txtViewCityName);
        TextView myPrice = findViewById(R.id.txtViewPrice);
        ImageView myBackImage = findViewById(R.id.imageView3);


        String MyRecord = getIntent().getStringExtra("DBINDEX");
        final Destination[] myDestination = {new Destination()};

        myBackImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailsActivity.this, MainActivity.class));
            }
        });

        DestinationDatabase myDb  = Room.databaseBuilder(getApplicationContext(), DestinationDatabase.class, "destinations.db").build();

        DestinationDao destinationDao = myDb.destinationDao();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //myDestinationList = destinationDao.GetAllDestinationData();
                myDest =  destinationDao.GetSelectedDestinationData(MyRecord);

                //myDest = myDestinationList.get(MyRecord);
                myDestImage.setImageResource(myDest.getDestinationPic());
                myCityName.setText(myDest.getDestinationName());
                myPrice.setText(Double.toString(myDest.getDestinationTicketPrice()));
            }
        });



    }
}