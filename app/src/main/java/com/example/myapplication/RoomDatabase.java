package com.example.myapplication;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;

import com.example.myapplication.DAOs.AdresseDAO;
import com.example.myapplication.DAOs.FavoritDAO;
import com.example.myapplication.DAOs.HofautomatBilderDAO;
import com.example.myapplication.DAOs.HofautomatDAO;
import com.example.myapplication.DAOs.HofautomatProduktDAO;
import com.example.myapplication.DAOs.KassenzettelDAO;
import com.example.myapplication.DAOs.ProduktDAO;
import com.example.myapplication.DAOs.UserBilderDAO;
import com.example.myapplication.DAOs.UserDOA;
import com.example.myapplication.Entitys.Adresse;
import com.example.myapplication.Entitys.Favorit;
import com.example.myapplication.Entitys.Hofautomat;
import com.example.myapplication.Entitys.HofautomatBilder;
import com.example.myapplication.Entitys.HofautomatProdukt;
import com.example.myapplication.Entitys.Kassenzettel;
import com.example.myapplication.Entitys.Produkt;
import com.example.myapplication.Entitys.User;
import com.example.myapplication.Entitys.UserBilder;

@Database(entities = {Produkt.class, Hofautomat.class, Adresse.class, Favorit.class,
        HofautomatBilder.class, Kassenzettel.class, HofautomatProdukt.class, User.class, UserBilder.class}, version = 1, exportSchema = false)
abstract class RoomDatabase extends androidx.room.RoomDatabase {

    public abstract ProduktDAO produktDAO();
    public abstract HofautomatDAO hofautomatDAO();
    public abstract AdresseDAO adresseDAO();
    public abstract FavoritDAO favoritDAO();
    public abstract HofautomatBilderDAO hofautomatBilderDAO();
    public abstract KassenzettelDAO kassenzettelDAO();
    public abstract HofautomatProduktDAO hofautomatProduktDAO();
    public abstract UserDOA userDOA();
    public abstract UserBilderDAO userBilderDAO();

    private static RoomDatabase INSTANCE;

    static RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    RoomDatabase.class,
                                    "e-business-db").build();
                }
            }
        }
        return INSTANCE;
    }
}
