package com.example.myapplication.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import com.example.myapplication.Entitys.Produkt;

@Dao
public interface ProduktDAO {

    @Query("SELECT * FROM Produkt")
    List<Produkt> getAll();

    @Insert
    void insertProdukt(Produkt produkt);

    @Delete
    void deleteProdukt(Produkt produkt);

    @Update
    void updateProdukt(Produkt produkt);

    @Query("SELECT * FROM Produkt WHERE name = :name")
    List<Produkt> findProductByName(String name);

    @Query("SELECT * FROM Produkt WHERE produktId = :produktId")
    List<Produkt> findProductById(int produktId);

    @Query("SELECT * FROM Produkt ORDER BY produktId DESC LIMIT 1")
    Produkt getLastProdukt();
}
