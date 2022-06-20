package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Entitys.Adresse;
import com.example.myapplication.Entitys.Favorit;
import com.example.myapplication.Entitys.Hofautomat;
import com.example.myapplication.Entitys.Produkt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomescreenActivity  extends AppCompatActivity {
    URoomDatabase db;
    private AppCompatButton loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);


        db = URoomDatabase.getDatabase(this);
    }


    /** Called when the user taps the Filter button */
    public void openFilter(View view) {
        Intent intent = new Intent(this, FilterActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Map button */
    public void openMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Favoriten button */
    public void openFavoriten(View view) {
        Intent intent = new Intent(this, FavoritenActivity.class);
        startActivity(intent);
    }
}