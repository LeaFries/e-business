package com.example.myapplication.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.myapplication.Entitys.Hofautomat;

@Dao
public interface HofautomatDAO {

    @Query("SELECT * FROM Hofautomat")
    List<Hofautomat> getAll();

    @Insert
    void insertHofautomat(Hofautomat hofautomat);

    @Delete
    void deleteHofautomat(Hofautomat hofautomat);

    @Update
    void updateHofautomat(Hofautomat hofautomat);

    @Query("SELECT * FROM Hofautomat WHERE name = :name")
    List<Hofautomat> findHofautomatByName(String name);

    @Query("SELECT * FROM Hofautomat WHERE hofautomatId = :hofautomatId")
    List<Hofautomat> findHofautomatById(int hofautomatId);
}
