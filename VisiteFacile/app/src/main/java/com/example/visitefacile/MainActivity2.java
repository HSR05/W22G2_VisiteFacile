package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.visitefacile.adapter.RecentsAdapter;
import com.example.visitefacile.adapter.TopPlacesAdapter;
import com.example.visitefacile.model.RecentsData;
import com.example.visitefacile.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recentRecycler,topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Alimatha Island","Maldives","From 900$",R.drawable.maldives));
        recentsDataList.add(new RecentsData("Taj Mahal","India","From 700$",R.drawable.india));
        recentsDataList.add(new RecentsData("Rincón de la Vieja","Costa Rica","From 600$",R.drawable.costarica));
        recentsDataList.add(new RecentsData("Sugar Loaf","Brazil","From 800$",R.drawable.brazil));

        setRecentRecycler(recentsDataList);
        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Bern","Switzerland","$2200 - $3500",R.drawable.bern));
        topPlacesDataList.add(new TopPlacesData("Stanley Park","Canada","$400 - $900",R.drawable.stanleypark));
        topPlacesDataList.add(new TopPlacesData("Taj Mahal","India","$900 - $1200",R.drawable.india));
        topPlacesDataList.add(new TopPlacesData("Rincón de la Vieja","Costa Rica","$1600 - $2100",R.drawable.costarica));

        setTopPlacesRecycler(topPlacesDataList);
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