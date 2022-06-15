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
import com.google.android.material.slider.RangeSlider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FilterActivity extends AppCompatActivity {
    URoomDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        db = URoomDatabase.getDatabase(this);

        initSearchWidgets();

    }



    private void initSearchWidgets(){
        final ListView listView = (ListView) findViewById(R.id.listViewGefiltert);


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                final List<Hofautomat> alleAutomaten = db.hofautomatDAO().getAll();
                final List<Adresse> alleAdressen = db.adresseDAO().getAll();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        SearchView searchView = (SearchView) findViewById(R.id.standortValue);
                        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String s) {
                                return false;
                            }


                            @Override
                            public boolean onQueryTextChange(String s) {
                                final ArrayList<Adresse> filteredAdressen = new ArrayList<Adresse>();
                                final ArrayList<Hofautomat> filtertAutomaten = new ArrayList<Hofautomat>();

                                for (Adresse adresse: alleAdressen){
                                    if(adresse.getOrt().toLowerCase().contains(s.toLowerCase()) || adresse.getPlz().contains(s.toLowerCase())){
                                        filteredAdressen.add(adresse);
                                        Hofautomat filterAutomaten = db.hofautomatDAO().getHofautomatByAdressId(adresse.getId());
                                        filtertAutomaten.add(filterAutomaten);
                                    }
                                }

                                BaseAdapter customBaseAdapter = new BaseAdapter() {
                                    // Return list view item count.
                                    @Override
                                    public int getCount() {
                                        return alleAutomaten.size();
                                    }

                                    @Override
                                    public Object getItem(int i) {
                                        return null;
                                    }

                                    @Override
                                    public long getItemId(int i) {
                                        return 0;
                                    }

                                    @Override
                                    public View getView(int itemIndex, View itemView, ViewGroup viewGroup) {

                                        if(itemView == null)
                                        {   // First inflate the RelativeView object.
                                            itemView = LayoutInflater.from(FilterActivity.this).inflate(R.layout.activity_listview_baseadapter, null);
                                        }

                                        // Find related view object inside the itemView.
                                        //ImageView imageView = (ImageView)itemView.findViewById(R.id.baseUserImage);
                                        TextView nameView = (TextView)itemView.findViewById(R.id.name);
                                        TextView adressView = (TextView)itemView.findViewById(R.id.adresse);

                                        // Set resources.
                                        //imageView.setImageResource(R.mipmap.ic_launcher);

                                        final String name = filtertAutomaten.get(itemIndex).getName();
                                        final String adresse = filteredAdressen.get(itemIndex).getPlz() + filteredAdressen.get(itemIndex).getOrt() + filteredAdressen.get(itemIndex).getStraße();
                                        nameView.setText(name);
                                        adressView.setText(adresse);

                                        // Find the button in list view row.
                               /* Button itemButton = (Button)itemView.findViewById(R.id.baseUserButton);
                                itemButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(ListViewActivity.this, "You click " + title + " , " + desc, Toast.LENGTH_SHORT).show();
                                    }
                                });*/

                                        return itemView;
                                    }
                                };


                                listView.setAdapter(customBaseAdapter);
                                return false;
                            }
                        });

                    }

            });
            }
        });




    }


}