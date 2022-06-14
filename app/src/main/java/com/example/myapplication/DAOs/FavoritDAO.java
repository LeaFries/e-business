package com.example.myapplication.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.myapplication.Entitys.Favorit;

@Dao
public interface FavoritDAO {

    @Query("SELECT * FROM Favorit")
    List<Favorit> getAll();

    @Insert
    void insertFavorit(Favorit favorit);

    @Delete
    void deleteFavorit(Favorit favorit);

    @Update
    void updateFavorit(Favorit favorit);

    @Query("SELECT * FROM Favorit WHERE favoritId = :favoritId")
    List<Favorit> findFavoritById(int favoritId);

    @Query("SELECT hofautomatId FROM Favorit WHERE userId = :userId")
    List<Integer> findFavoritForUserByUserId(int userId);
}
