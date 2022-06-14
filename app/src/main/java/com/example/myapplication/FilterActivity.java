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
import java.util.Map;

public class FilterActivity extends AppCompatActivity {
    URoomDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        db = URoomDatabase.getDatabase(this);

        initSearchWidgets();

        //Entfernungsslider erstmal nicht benutzen
        TextView entfernungValue = findViewById(R.id.entfernungValue);
        RangeSlider entfernungSlider = findViewById(R.id.entfernungSlider);
        entfernungSlider.addOnChangeListener((slider, value, fromUser) -> {
            int intValue = (int) Math.round(value);
            entfernungValue.setText(Integer.valueOf(intValue) + " km");
                }
        );
    }

    private void initSearchWidgets(){
        final ListView listView = (ListView) findViewById(R.id.listViewGefiltert);
        final ArrayList<String> listNamen = new ArrayList<String>();
        final ArrayList<String> listAdressen = new ArrayList<>();
        ArrayList<Map<String, String>> mappedList = new ArrayList<Map<String, String>>();
        ArrayList<String> list = new ArrayList<>();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                //Alle Hofautomaten in Liste speichern
                final List<Hofautomat> alleAutomaten = db.hofautomatDAO().getAll();

                //Lade die Namen der Hofautomaten
                runOnUiThread(new Runnable() {
                                  @Override
                                  public void run() {

                                      for (int i = 0; i < alleAutomaten.size(); ++i) {
                                          listNamen.add(alleAutomaten.get(i).getName());
                                          Adresse adresse = db.adresseDAO().findAdresse(alleAutomaten.get(i).getAdresseId());
                                          listAdressen.add(adresse.getStraße() + " " + adresse.getHausnummer() + ", " + adresse.getPlz() + " " + adresse.getOrt());
                                      }

                                      ArrayList<Map<String, String>> mappedList = new ArrayList<Map<String, String>>();
                                      for(int i = 0; i < listNamen.size(); ++i){
                                          Map<String,String> listItemMap = new HashMap<String, String>();
                                          listItemMap.put("Name", listNamen.get(i));
                                          listItemMap.put("Adresse", listAdressen.get(i));
                                          mappedList.add(listItemMap);
                                      }
                                  }
                });
            }
        });

        BaseAdapter customBaseAdapter = new BaseAdapter() {
            // Return list view item count.
            @Override
            public int getCount() {
                return mappedList.size();
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

                final String name = listNamen.get(itemIndex);
                final String adresse = listAdressen.get(itemIndex);
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

        SearchView searchView = (SearchView) findViewById(R.id.standortValue);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }


            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Map<String, String>> filteredHofautomaten = new ArrayList<>();
                for(Map<String, String> hofautomat: mappedList){
                    if(hofautomat.toString().toLowerCase().contains(s.toLowerCase())){
                        filteredHofautomaten.add(hofautomat);
                    }
                }

                listView.setAdapter(customBaseAdapter);
                return false;
            }
        });
    }

    /** Called when the user taps the Suche button */
    public void tapsOnFilter(View view) {
        Button b1 = (Button) findViewById(R.id.milchCheckBox);
    }




}