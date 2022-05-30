package com.example.myapplication.Helper;

import android.os.AsyncTask;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Entitys.Produkt;

import java.util.List;
import java.util.jar.Attributes;


public class Mockdata{


    @Query( "INSERT INTO Produkt (name, preis, beschreibung)" +
            "VALUES ('test', 5,'beschreibung')," +
            "       ('test', 5,'beschreibung')")

    public void onSaveButtonPressed() {

    }
}

