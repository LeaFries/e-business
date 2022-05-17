package com.example.myapplication.DAOs;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Entitys.HofautomatBilder;
import com.example.myapplication.Entitys.Hofautomat;

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

        @Query("SELECT * FROM Hofautomat WHERE hofautomatId = :hofautomatId")
        List<HofautomatBilder> findHofautomatBilder(int hofautomatId);
}
