package com.example.visitefacile.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.visitefacile.DetailsActivity;
import com.example.visitefacile.R;
import com.example.visitefacile.model.RecentsData;
import com.example.visitefacile.model.TopPlacesData;

import java.util.List;

public class TopPlacesAdapter extends RecyclerView.Adapter<TopPlacesAdapter.TopPlacesHolder> {
    Context context;
    List<TopPlacesData> topPlacesDataList;

    public TopPlacesAdapter(Context context, List<TopPlacesData> topPlacesDataList) {
        this.context = context;
        this.topPlacesDataList = topPlacesDataList;
    }

    @NonNull
    @Override
    public TopPlacesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.top_row_places_item,parent,false);

        return new TopPlacesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopPlacesHolder holder, int position)
    {
     holder.countryName.setText(topPlacesDataList.get(position).getCountryName());
     holder.placeName.setText(topPlacesDataList.get(position).getPlaceName());
     holder.price.setText(topPlacesDataList.get(position).getPrice());
     holder.placeImage.setImageResource(topPlacesDataList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                Intent i = new Intent(context, DetailsActivity.class);
                /*

                // Error in passing position

                switch (position)
                {
                    case 0:
                        String placeName = "Bern";
                        b.putString("placeName",placeName);
                        String countryName = "Switzerland";
                        b.putString("countryName",countryName);
                        String price = "$2200 - $3500";
                        b.putString("price",price);
                        i.putExtras(b);
                        i.putExtra("image",R.drawable.bern);
                        context.startActivity(i);
                        break;
                    case 1:


                        placeName = "Stanley Park";
                        b.putString("placename",placeName);
                        countryName = "Canada";
                        b.putString("countryName",countryName);
                        price = "$400 - $900";
                        b.putString("price",price);
                        i.putExtras(b);
                        i.putExtra("image",R.drawable.stanleypark);
                        context.startActivity(i);
                        break;
                    case 2:
                        placeName = "Taj Mahal";
                        b.putString("placename",placeName);
                        countryName = "India";
                        b.putString("countryName",countryName);
                        price = "$900 - $1200";
                        b.putString("price",price);
                        i.putExtras(b);
                        i.putExtra("image",R.drawable.india);
                        context.startActivity(i);
                        break;
                    case 3:
                        placeName = "Rincón de la Vieja";
                        b.putString("placename",placeName);
                        countryName = "Costa Rica";
                        b.putString("countryName",countryName);
                        price = "$1600 - $2100";
                        b.putString("price",price);
                        i.putExtras(b);
                        i.putExtra("image",R.drawable.costarica);
                        context.startActivity(i);
                        break;
                }
*/
            }
        });



    }

    @Override
    public int getItemCount() {
        return topPlacesDataList.size();
    }


    public static final class TopPlacesHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, countryName, price;
        public TopPlacesHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);
            price = itemView.findViewById(R.id.price);



        }
    }


}
