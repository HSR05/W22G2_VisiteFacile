package com.example.visitefacile.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

     holder.itemView.setOnClickListener(new View.OnClickListener()
     {
         @Override
         public void onClick(View view) {
             Bundle b = new Bundle();
             Intent i = new Intent(context, DetailsActivity.class);
             /*
             switch (position)
             {
                 case 0:
                     String placeName = "Alimatha Island";
                     b.putString("placeName",placeName);
                     String countryName = "Maldives";
                     b.putString("countryName",countryName);
                     String price = "900$";
                     b.putString("price",price);
                     i.putExtras(b);
                     i.putExtra("image",R.drawable.maldives);
                     context.startActivity(i);
                     break;
                 case 1:


                      placeName = "Taj Mahal";
                     b.putString("placename",placeName);
                      countryName = "India";
                     b.putString("countryName",countryName);
                      price = "700$";
                     b.putString("price",price);
                     i.putExtras(b);
                     i.putExtra("image",R.drawable.india);
                     context.startActivity(i);
                     break;
                 case 2:

                      placeName = "Rincón de la Vieja";
                     b.putString("placename",placeName);
                      countryName = "Costa Rica";
                     b.putString("countryName",countryName);
                      price = "600$";
                     b.putString("price",price);
                     i.putExtras(b);
                     i.putExtra("image",R.drawable.costarica);
                     context.startActivity(i);
                     break;
                 case 3:
                      placeName = "Sugar Loaf";
                     b.putString("placename",placeName);
                      countryName = "Brazil";
                     b.putString("countryName",countryName);
                      price = "800$";
                     b.putString("price",price);
                     i.putExtras(b);
                     i.putExtra("image",R.drawable.brazil);
                     context.startActivity(i);
                     break;
             }
*/
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
