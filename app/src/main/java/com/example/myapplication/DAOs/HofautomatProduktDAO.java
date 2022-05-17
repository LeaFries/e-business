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
    void insertHofautomatProdukt(HofautomatProdukt hofautomatProdukt);

    @Delete
    void deleteHofautomatProdukt(HofautomatProdukt hofautomatProdukt);

    @Update
    void updateHofautomatProdukt(HofautomatProdukt hofautomatProdukt);

    @Query("SELECT * FROM HofautomatProdukt WHERE hofautomatProduktId = :hofautomatProduktId")
    List<HofautomatProdukt> findHofautomatProdukteById(int hofautomatProduktId);
}
