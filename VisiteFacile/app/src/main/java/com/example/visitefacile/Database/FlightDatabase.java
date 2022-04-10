package com.example.visitefacile.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.visitefacile.adapter.FlightEntity;
import com.example.visitefacile.adapter.UserEntity;


@Database(entities = {FlightEntity.class},version = 1,exportSchema = false)
public abstract class FlightDatabase extends RoomDatabase {

    private static final String dbName = "flight";
    private static FlightDatabase flightDatabase;

    public static synchronized FlightDatabase getFlightDatabase (Context context) {
        if (flightDatabase == null) {
            flightDatabase = Room.databaseBuilder(context,FlightDatabase.class,dbName).fallbackToDestructiveMigration().build();

        }
        return flightDatabase;
    }

    public abstract FlightDao flightDao();
}
