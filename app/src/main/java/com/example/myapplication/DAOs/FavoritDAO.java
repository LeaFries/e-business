package com.example.myapplication.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.myapplication.Entitys.Favorit;
import com.example.myapplication.Entitys.Hofautomat;
import com.example.myapplication.Entitys.User;

@Dao
public interface FavoritDAO {

    @Query("SELECT * FROM Favorit")
    List<Favorit> getAll();

    @Insert
    void insertAdresse(Favorit adresse);

    @Delete
    void deleteAdresse(Favorit adresse);

    @Update
    void updateAdresse(Favorit adresse);

    @Query("SELECT * FROM Favorit WHERE hofautomatId = :hofautomatId")
    List<Hofautomat> findFavoritHofautomat(int hofautomatId);

    @Query("SELECT * FROM Favorit WHERE userId = :userId")
    List<User> findFavoritUser(int userId);

}
