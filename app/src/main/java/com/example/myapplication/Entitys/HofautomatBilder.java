package com.example.myapplication.Entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

import javax.annotation.Nonnull;

@Entity(foreignKeys = {@ForeignKey(entity = Hofautomat.class,
        parentColumns = "hofautomatId",
        childColumns = "hofautomatId",
        onDelete = ForeignKey.CASCADE)},
        tableName = "HofautomatBilder")
public class HofautomatBilder {

    @PrimaryKey(autoGenerate = true)
    @Nonnull
    @ColumnInfo(name = "hofautomatBilderId")
    private int id;

    @ColumnInfo(name = "Datum")
    private Date datum;

    @ColumnInfo(name = "label")
    private String label;

    @ColumnInfo(name = "hofautomatId")
    private String hofautomatId;


    public HofautomatBilder(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHofautomatId() {
        return hofautomatId;
    }

    public void setHofautomatId(String hofautomatId) {
        this.hofautomatId = hofautomatId;
    }
}