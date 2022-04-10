package com.example.visitefacile.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.visitefacile.adapter.FlightEntity;
import com.example.visitefacile.adapter.UserEntity;

@Dao
public interface FlightDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bookFlight(FlightEntity flightEntity);

    @Query("SELECT * FROM flight where userId=(:userId)")
    FlightEntity flightDetails(String userId);
}
