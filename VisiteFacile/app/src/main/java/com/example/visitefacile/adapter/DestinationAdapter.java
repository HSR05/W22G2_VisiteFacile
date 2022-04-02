package com.example.visitefacile.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class DestinationAdapter extends BaseAdapter {

    List<Destination> Destination;

    public DestinationAdapter(List<Destination> destination) {
        Destination = destination;
    }

    @Override
    public int getCount() {
        return Destination.size();
    }

    @Override
    public Object getItem(int i) {
        return Destination.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
