package com.example.visitefacile.adapter;

import android.content.Context;
import android.content.Intent;
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
    List<RecentsData> recentsDataList;

    public RecentsAdapter(Context context, List<RecentsData> recentsDataList) {
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
     holder.countryName.setText(recentsDataList.get(position).getCountryName());
     holder.placeName.setText(recentsDataList.get(position).getPlaceName());
     holder.price.setText(recentsDataList.get(position).getPrice());
     holder.placeImage.setImageResource(recentsDataList.get(position).getImageUrl());

     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent i = new Intent(context, DetailsActivity.class);
             context.startActivity(i);
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
