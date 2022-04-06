package com.example.visitefacile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.visitefacile.Database.RoomDb;
import com.example.visitefacile.adapter.MainAdapter;
import com.example.visitefacile.model.MainData;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class FavActivity extends AppCompatActivity  {

    ImageView imageViewback;
    EditText editText;
    Button btAdd,btReset;
    RecyclerView recyclerView;

    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDb database;
    MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        editText = findViewById(R.id.edit_text);
        btAdd = findViewById(R.id.bt_add);
        btReset = findViewById(R.id.bt_reset);
        recyclerView = findViewById(R.id.recycler_view);
        imageViewback = findViewById(R.id.imageViewback);

        database = RoomDb.getInstance(this);
        dataList = database.mainDao().getAll();

        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MainAdapter(dataList, FavActivity.this);

        recyclerView.setAdapter(adapter);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sText = editText.getText().toString().trim();

                if (!sText.equals("")){
                    MainData data = new MainData();
                    data.setText(sText);
                    database.mainDao().insert(data);
                    editText.setText("");
                    dataList.clear();
                    dataList.addAll(database.mainDao().getAll());
                    adapter.notifyDataSetChanged();
                }
            }
        });
        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FavActivity.this, MainActivity.class));
                //startActivity(new Intent(DetailsActivity.this, FavActivity.class));
            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.mainDao().reset(dataList);
                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
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
                        Toast.makeText(FavActivity.this, "Clicked on Home", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(FavActivity.this,MainActivity.class));
                        break;

                    case R.id.cities:
                        //user
                        Toast.makeText(FavActivity.this, "Clicked on Favorites", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(FavActivity.this,TopCitiesActivity.class));
                        break;
                    case R.id.rating:
                        //raing
                        Toast.makeText(FavActivity.this, "Clicked on Rating", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(FavActivity.this,RatingActivity.class));
                        break;

                }
                return false;
            }
        });



    }

}