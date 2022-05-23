package com.example.myapplication.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Entitys.User;

import java.util.List;

@Dao
public interface UserDOA {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);

    @Query("SELECT * FROM User WHERE userId = :userId")
    List<User> findUserById(int userId);

    @Query("SELECT Rolle FROM User WHERE userId = :userId")
    int getUserRoleById(int userId);
}
