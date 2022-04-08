package com.example.visitefacile.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.visitefacile.adapter.UserEntity;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void registerUser(UserEntity userEntity);

    @Query("SELECT * FROM users where userId=(:userId) and password=(:password)")
    UserEntity login(String userId,String password);
}
