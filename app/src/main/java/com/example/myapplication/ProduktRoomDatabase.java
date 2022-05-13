package com.example.myapplication;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.myapplication.DAOs.ProduktDAO;
import com.example.myapplication.Entitys.Produkt;

@Database(entities = {Produkt.class}, version = 1, exportSchema = false)
abstract class ProduktRoomDatabase extends RoomDatabase {

    public abstract ProduktDAO produktDAO();
    private static ProduktRoomDatabase INSTANCE;

    static ProduktRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProduktRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    ProduktRoomDatabase.class,
                                    "name_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
