package com.example.myapplication.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.myapplication.Entitys.Adresse;
import com.example.myapplication.Entitys.Produkt;

@Dao
public interface AdresseDAO {

    @Query("SELECT * FROM Adresse")
    List<Adresse> getAll();

    @Insert
    void insertAdresse(Adresse adresse);

    @Delete
    void deleteAdresse(Adresse adresse);

    @Update
    void updateAdresse(Adresse adresse);

    @Query("SELECT * FROM Adresse WHERE adresseId = :adresseId")
    List<Adresse> findAdresse(int adresseId);
}
