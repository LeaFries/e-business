package com.example.myapplication.Entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import javax.annotation.Nonnull;

@Entity(tableName = "Produkt")
public class Produkt {

    @PrimaryKey(autoGenerate = true)
    @Nonnull
    @ColumnInfo(name = "produktId")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "preis")
    private double preis;

    @ColumnInfo(name = "beschreibung")
    private String beschreibung;

    public Produkt(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
