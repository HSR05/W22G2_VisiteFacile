package com.example.visitefacile.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.visitefacile.adapter.Destination;

@Database(entities = {Destination.class},version = 1,exportSchema = false)
public abstract class DestinationDatabase extends RoomDatabase {
    public abstract DestinationDao destinationDao();
}

