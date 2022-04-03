package com.example.visitefacile.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.visitefacile.DetailsActivity;
import com.example.visitefacile.R;
import com.example.visitefacile.model.RecentsData;

import org.w3c.dom.Text;

import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentViewHolder> {
    Context context;
    List<Destination> recentsDataList;

    public RecentsAdapter(Context context, List<Destination> recentsDataList) {
        this.context = context;
        this.recentsDataList = recentsDataList;
    }

    @NonNull
    @Override
    public RecentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recents_row_item,parent,false);

        return new RecentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentViewHolder holder, int position) {
     holder.countryName.setText(recentsDataList.get(position).getDestinationCountryName());
     holder.placeName.setText(recentsDataList.get(position).getDestinationName());
     holder.price.setText(Double.toString(recentsDataList.get(position).getDestinationTicketPrice()));
     holder.placeImage.setImageResource(recentsDataList.get(position).getDestinationPic());


     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i = new Intent(context, DetailsActivity.class);
             Bundle myBundle = new Bundle();


             context.startActivity(i.putExtra("DBINDEX", recentsDataList.get(holder.getAdapterPosition()).getDestinationName()));
         }
     });

    }

    @Override
    public int getItemCount() {
        return recentsDataList.size();
    }


    public static final class RecentViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, countryName, price;

        public RecentViewHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);
            price = itemView.findViewById(R.id.price);


        }
    }


}
