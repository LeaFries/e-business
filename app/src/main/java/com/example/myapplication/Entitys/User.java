package com.example.myapplication.Entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.lang.annotation.Target;

import javax.annotation.Nonnull;

@Entity(foreignKeys = {@ForeignKey(entity = Kassenzettel.class,
        parentColumns = "kassenzettelId",
        childColumns = "kassenzettelId",
        onDelete = ForeignKey.CASCADE)}
        ,tableName = "User")

public class User {

    @PrimaryKey(autoGenerate = true)
    @Nonnull
    @ColumnInfo(name = "userId")
    private int id;

    @ColumnInfo(name = "hofautomatId")
    private String hofautomatId;

    @ColumnInfo(name = "vorname")
    private String vorname;

    @ColumnInfo(name = "nachname")
    private String nachname;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "rolle")
    private String rolle;

    @ColumnInfo(name = "punkte")
    private int punkte;

    @ColumnInfo(name = "kassenzettelId")
    private int kassenzettelId;

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHofautomatId() {
        return hofautomatId;
    }

    public void setHofautomatId(String hofautomatId) {
        this.hofautomatId = hofautomatId;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public int getKassenzettelId() {
        return kassenzettelId;
    }

    public void setKassenzettelId(int kassenzettelId) {
        this.kassenzettelId = kassenzettelId;
    }
}

