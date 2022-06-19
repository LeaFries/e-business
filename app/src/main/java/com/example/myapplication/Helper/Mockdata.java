package com.example.myapplication.Helper;

import android.os.AsyncTask;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Entitys.Produkt;

import java.util.List;
import java.util.jar.Attributes;


public class Mockdata{


    @Query( "INSERT INTO Produkt (name, preis, beschreibung)" +
            "VALUES ('Eier', 5, 'Freilandhaltung Eier')," +
            "       ('Äpfel', 6.5,'Elstar Äpfel')")
    public void insertProdukte1() {}

    @Query("INSERT INTO User (hofautomatId, vorname, nachname, email, rolle, punkte)" +
            "VALUES (null, 'Max', 'Müller', 'max.müller@gmail.com', 'benutzer', 0)," +
            "       (null, 'Peter', 'Random', 'peter.random@gmail.com', 'bauer', 0)," +
            "       (null, 'Thomas', 'Günther', 'thomas.günther@gmail.com', 'bauer', 0)," +
            "       (null, 'Thomas', 'Leonhardt', 'thomas.leonhardt@gmail.com', 'bauer', 0)")
    public void insertUsers() {}

    @Query("INSERT INTO Adresse (userId, straße, plz, hausnummer, ort)" +
            "VALUES (1, 'Lerchenweg', '76133', 4, 'Karlsruhe')," +
            "       (2, 'Durlacher Str.', '76275', 36, 'Ettlingen')," +
            "       (3, 'Herbstraße', '76275', 2, 'Ettlingen')," +
            "       (4, 'Pforzheimer Str.', '75196', 30, 'Remchingen')")
    public void insertAdresse() {}

    @Query("INSERT INTO Hofautomat (userId, adresseId, name)" +
            "VALUES (2, 2, 'Hedwighof')," +
            "       (3, 3,'Eier- und Geflügelhof'),"+
            "       (4, 4,'Leonhardt Hofautomat')")
    public void insertHofautomat() {}

    @Query("Update User set hofautomatId = 1 where userId = 2")
    public void updateUser1() {}

    @Query("Update User set hofautomatId = 2 where userId = 3")
    public void updateUser2() {}

    @Query("Update User set hofautomatId = 3 where userId = 4")
    public void updateUser3() {}

    @Query("INSERT INTO HofautomatProdukt (produktId, hofautomatId)" +
            "VALUES (1, 1)," +
            "       (2, 1),"+
            "       (1, 2)")
    public void insertHofautomatProdukt() {}

    @Query("INSERT INTO Favorit (userId, hofautomatId)" +
            "VALUES (1, 1)")
    public void insertFavoriten(){}

    @Query( "INSERT INTO Produkt (name, preis, beschreibung)" +
            "VALUES ('Brot', 2.5, 'Selbstgemachtes Dinkelbrot')," +
            "       ('Eier', 5,'Bodenhaltung Eier')," +
            "       ('Kartoffeln', 3.5,'Festkochende Kartoffeln')," +
            "       ('Wurst', 3,'10er Pack Grillwurst')," +
            "       ('Wurst', 2.5,'Fleischwurst')," +
            "       ('Milch')")
    public void insertProdukte2(){}
}

