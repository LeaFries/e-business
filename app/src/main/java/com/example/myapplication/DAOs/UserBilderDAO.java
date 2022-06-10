package com.example.myapplication.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Entitys.UserBilder;

import java.util.List;

@Dao
public interface UserBilderDAO {
    @Query("SELECT * FROM UserBilder")
    List<UserBilder> getAll();

    @Insert
    void insertUser(UserBilder userBilder);

    @Delete
    void deleteUser(UserBilder userBilder);

    @Update
    void updateUser(UserBilder userBilder);

    @Query("SELECT * FROM UserBilder WHERE userBilderId = :userBilderId")
    List<UserBilder> findUserBildById(int userBilderId);

}
