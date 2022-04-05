package com.example.visitefacile.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.visitefacile.model.MainData;

import java.util.List;

@Dao
public interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MainData mainData);

    @Delete
    void delete(MainData mainData);

    @Delete
    void reset(List<MainData> mainData);

    @Query("UPDATE table_name SET text = :sText WHERE ID = :sID")
    void update(int sID,String sText);

    @Query("SELECT * FROM table_name")
    List<MainData> getAll();
}
