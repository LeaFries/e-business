package com.example.myapplication.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.myapplication.Entitys.HofautomatProdukt;

@Dao
public interface HofautomatProduktDAO {

    @Query("SELECT * FROM HofautomatProdukt")
    List<HofautomatProdukt> getAll();

    @Insert
    void insertProdukt(HofautomatProdukt hofautomatProdukt);

    @Delete
    void deleteProdukt(HofautomatProdukt hofautomatProdukt);

    @Update
    void updateProdukt(HofautomatProdukt hofautomatProdukt);

    @Query("SELECT * FROM HofautomatProdukt WHERE hofautomatProduktId = :hofautomatProduktId")
    List<HofautomatProdukt> findHofautomatProdukte(int hofautomatProduktId);
}
