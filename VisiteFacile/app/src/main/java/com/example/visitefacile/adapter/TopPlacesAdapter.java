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
    List<Destination> topPlacesDataList;

    public TopPlacesAdapter(Context context, List<Destination> topPlacesDataList) {
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
     holder.countryName.setText(topPlacesDataList.get(position).getDestinationCountryName());
     holder.placeName.setText(topPlacesDataList.get(position).getDestinationName());
     holder.price.setText(Double.toString(topPlacesDataList.get(position).getDestinationTicketPrice()));
     holder.placeImage.setImageResource(topPlacesDataList.get(position).getDestinationPic());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailsActivity.class);
                Bundle myBundle = new Bundle();


                context.startActivity(i.putExtra("DBINDEX", topPlacesDataList
                                                                        .get(holder.getAdapterPosition())
                                                                .getDestinationName()));
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
