package com.example.myapplication.Entitys;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import javax.annotation.Nonnull;

@Entity(foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "userId",
        childColumns = "userId",
        onDelete = ForeignKey.CASCADE),
    @ForeignKey(entity = Adresse.class, parentColumns = "adresseId",
        childColumns = "adresseId",
        onDelete = ForeignKey.CASCADE)},
        tableName = "Hofautomat")
public class Hofautomat {

    @PrimaryKey(autoGenerate = true)
    @Nonnull
    @ColumnInfo(name = "hofautomatId")
    private int id;

    @ColumnInfo(name = "userId")
    private int userId;

    @ColumnInfo(name = "adresseId")
    private int adresseId;

    @ColumnInfo(name = "name")
    private String name;

    public Hofautomat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(int adresseId) {
        this.adresseId = adresseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
