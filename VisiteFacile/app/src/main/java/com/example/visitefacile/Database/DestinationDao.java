package com.example.visitefacile.Database;
import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.visitefacile.adapter.Destination;

import java.util.List;

@Dao
public interface DestinationDao {
    @Insert(onConflict = REPLACE)
    void insertDestination(List<Destination> destinationList);

    @Query("SELECT * FROM mydestination")
    List<Destination> GetAllDestinationData();

    @Query("SELECT * FROM mydestination WHERE destinationname=:myDest")
    Destination GetSelectedDestinationData(String myDest);


}
