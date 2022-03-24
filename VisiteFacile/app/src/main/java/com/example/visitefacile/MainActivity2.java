package com.example.visitefacile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.visitefacile.adapter.RecentsAdapter;
import com.example.visitefacile.model.RecentsData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;

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
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList){

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this,recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

}