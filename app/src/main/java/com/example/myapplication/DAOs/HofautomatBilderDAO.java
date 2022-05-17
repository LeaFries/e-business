package com.example.myapplication.DAOs;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Entitys.HofautomatBilder;


import java.util.List;

public interface HofautomatBilderDAO
{
        @Query("SELECT * FROM HofautomatBilder")
        List<HofautomatBilder> getAll();

        @Insert
        void insertHofautomatBilder(HofautomatBilder hofautomat);

        @Delete
        void deleteHofautomatBilder(HofautomatBilder hofautomat);

        @Update
        void updateHofautomatBilder(HofautomatBilder hofautomat);

        @Query("SELECT * FROM HofautomatBilder WHERE hofautomatBilderId = :hofautomatBilderId")
        List<HofautomatBilder> findHofautomatBilder(int hofautomatBilderId);

        @Query("SELECT * FROM HofautomatBilder WHERE hofautomatId = :hofautomatId")
        List<HofautomatBilder> findHofautomatBilderByHofautomatId(int hofautomatId);
}
