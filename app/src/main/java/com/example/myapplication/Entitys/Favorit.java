package com.example.myapplication.Entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import javax.annotation.Nonnull;

@Entity(foreignKeys = {
        @ForeignKey(entity = User.class,
        parentColumns = "userId",
        childColumns = "userId",
        onDelete = ForeignKey.CASCADE)},
        //@ForeignKey(entity = Hofautomat.class,
          //      parentColumns = "hofautomatId",
            //    childColumns = "hofautomatId",
              //  onDelete = ForeignKey.CASCADE)},

        tableName = "Favorit")
public class Favorit {

    @PrimaryKey(autoGenerate = true)
    @Nonnull
    @ColumnInfo(name = "favoritId")
    private int id;

    @ColumnInfo(name = "userId")
    private int userId;

    @ColumnInfo(name = "hofautomatId")
    private int hofautomatId;


    public Favorit(){}

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

    public int getHofautomatId() {
        return hofautomatId;
    }

    public void setHofautomatId(int hofautomatId) {
        this.hofautomatId = hofautomatId;
    }

}