package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.shapes.Shape;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.myapplication.Entitys.Adresse;
import com.example.myapplication.Entitys.Hofautomat;
import com.example.myapplication.Entitys.Produkt;
import com.example.myapplication.Helper.AutomatAdapter;
import com.example.myapplication.Helper.ProduktAdapter;
import com.google.android.material.slider.RangeSlider;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FilterActivity extends AppCompatActivity
{
    URoomDatabase db;
    public static ArrayList<Produkt> alleProdukte = new ArrayList<Produkt>();
    public static ArrayList<Integer> hofAutomatenId = new ArrayList<Integer>();
    public static ArrayList<Hofautomat> filteredHofautomaten = new ArrayList<Hofautomat>();
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        db = URoomDatabase.getDatabase(this);
        setUpData();
        initSearchWidgets();


    }


    private void setUpData() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                final List<Hofautomat> alleAutomaten = db.hofautomatDAO().getAll();
                final List<Adresse> alleAdressen = db.adresseDAO().getAll();
                final List<Produkt> produkte = db.produktDAO().getAll();
                for (Produkt produkt : produkte) {
                    alleProdukte.add(produkt);
                }
            }
        });

    }

    private void initSearchWidgets() {
        listView = (ListView) findViewById(R.id.listViewGefiltert);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                SearchView searchView = (SearchView) findViewById(R.id.hofautomatFilterView);

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                    public boolean onQueryTextSubmit(String s) {
                        return false;
                    }


                    @Override
                    public boolean onQueryTextChange(String s) {
                        ArrayList<Produkt> gefilterteProdukte = new ArrayList<Produkt>();
                        for (Produkt produkt : alleProdukte) {
                            if (produkt.getName().toLowerCase().contains(s)) {
                                gefilterteProdukte.add(produkt);
                            }
                        }
                        for(Produkt produkt: gefilterteProdukte)
                        {
                        Integer automatId = db.hofautomatProduktDAO().findHofautomatByProduktId(produkt.getId());
                        hofAutomatenId.add(automatId);
                        }

                        for(Integer integer : hofAutomatenId)
                        {
                            Hofautomat hofautomaten = db.hofautomatDAO().findHofautomatById(integer);
                            filteredHofautomaten.add(hofautomaten);

                        }

                        AutomatAdapter adapter = new AutomatAdapter(getApplicationContext(), 0, filteredHofautomaten);
                        listView.setAdapter(adapter);

                        return false;
                    }
                });

            }
        });

    }
}




