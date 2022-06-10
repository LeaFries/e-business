package com.example.myapplication.Entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import javax.annotation.Nonnull;

@Entity(foreignKeys = {@ForeignKey(entity = Produkt.class, parentColumns = "produktId",
        childColumns = "produktId",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Hofautomat.class, parentColumns = "hofautomatId",
                childColumns = "hofautomatId",
                onDelete = ForeignKey.CASCADE)},
        tableName = "HofautomatProdukt")
public class HofautomatProdukt {

    @PrimaryKey(autoGenerate = true)
    @Nonnull
    @ColumnInfo(name = "hofautomatProduktId")
    private int id;

    @ColumnInfo(name = "produktId")
    private int produktId;

    @ColumnInfo(name = "hofautomatId")
    private int hofautomatId;

    public HofautomatProdukt(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduktId() {
        return produktId;
    }

    public void setProduktId(int produktId) {
        this.produktId = produktId;
    }

    public int getHofautomatId() {
        return hofautomatId;
    }

    public void setHofautomatId(int hofautomatId) {
        this.hofautomatId = hofautomatId;
    }
}
