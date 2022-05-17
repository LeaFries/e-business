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
        void insertHofautomatBilder(HofautomatBilder hofautomatbilder);

        @Delete
        void deleteHofautomatBilder(HofautomatBilder hofautomatbilder);

        @Update
        void updateHofautomatBilder(HofautomatBilder hofautomatbilder);

        @Query("SELECT * FROM HofautomatBilder WHERE hofautomatBilderId = :hofautomatBilderId")
        List<HofautomatBilder> findHofautomatBilderById(int hofautomatBilderId);

        @Query("SELECT * FROM HofautomatBilder WHERE hofautomatId = :hofautomatId")
        List<HofautomatBilder> findHofautomatBilderByHofautomatId(int hofautomatId);
}
