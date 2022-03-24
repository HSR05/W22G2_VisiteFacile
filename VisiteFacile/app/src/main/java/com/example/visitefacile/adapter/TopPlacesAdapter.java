package com.example.visitefacile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onBindViewHolder(@NonNull TopPlacesHolder holder, int position) {
     holder.countryName.setText(topPlacesDataList.get(position).getCountryName());
     holder.placeName.setText(topPlacesDataList.get(position).getPlaceName());
     holder.price.setText(topPlacesDataList.get(position).getPrice());
     holder.placeImage.setImageResource(topPlacesDataList.get(position).getImageUrl());
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
