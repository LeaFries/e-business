package com.example.myapplication.Entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import javax.annotation.Nonnull;

@Entity(foreignKeys = {@ForeignKey(entity = User.class,
        parentColumns = "userId",
        childColumns = "userId",
        onDelete = ForeignKey.CASCADE)}
        ,tableName = "Kassenzettel")
public class Kassenzettel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kassenzettelId")
    private int id;

    @ColumnInfo(name = "userId")
    private int userId;


    public Kassenzettel(){}

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

}