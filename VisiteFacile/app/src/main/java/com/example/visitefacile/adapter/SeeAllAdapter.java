package com.example.visitefacile.adapter;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.visitefacile.R;

import java.util.ArrayList;
import java.util.List;

public class SeeAllAdapter extends BaseAdapter {

    List<Destination> MyDestinations = new ArrayList<>();

    public SeeAllAdapter(List<Destination> myDestinations) {
        MyDestinations = myDestinations;
    }

    @Override
    public int getCount() {
        return MyDestinations.size();
    }

    @Override
    public Destination getItem(int i) {
        return MyDestinations.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_listviewplaces, viewGroup, false);
        }

        ImageView myPlaceImage= view.findViewById(R.id.imgViewSeeAllPlaces);
        TextView myTextDestination =view.findViewById(R.id.txtViewMyAllPlace);

        String myPlaceStr = "<b>"+"Name: "+"</b>"+MyDestinations.get(i).getDestinationName()+"<br>"+
                "<b>"+"Country: "+"</b>"+MyDestinations.get(i).getDestinationCountryName()+"<br>"+
                "<b>"+"Price: "+"</b>"+MyDestinations.get(i).getDestinationTicketPrice();

        myTextDestination.setText(Html.fromHtml(myPlaceStr));
        myPlaceImage.setImageResource(MyDestinations.get(i).getDestinationPic());



        return view;
    }
}