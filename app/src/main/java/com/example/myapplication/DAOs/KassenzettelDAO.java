package com.example.myapplication.DAOs;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Entitys.Kassenzettel;

import java.util.List;

public interface KassenzettelDAO {
    @Query("SELECT * FROM Kassenzettel")
    List<Kassenzettel> getAll();

    @Insert
    void insertKassenzettel(Kassenzettel kassenzettel);

    @Delete
    void deleteKassenzettel(Kassenzettel kassenzettel);

    @Update
    void updateKazzenzettel(Kassenzettel kassenzettel);

    @Query("SELECT * FROM Kassenzettel WHERE kassenzettelId = :kassenzettelId")
    List<Kassenzettel> findKassenzettelById(int kassenzettelId);

    @Query("SELECT * FROM Kassenzettel WHERE userID = :userId")
    List<Kassenzettel> findKassenzettelByUserId(int userId);
}
