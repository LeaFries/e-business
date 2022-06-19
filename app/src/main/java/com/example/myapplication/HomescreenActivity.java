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

public class HomescreenActivity  extends AppCompatActivity implements View.OnClickListener {
    URoomDatabase db;
    private AppCompatButton loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        loadButton = findViewById(R.id.load_b);


        loadButton.setOnClickListener(this);

        db = URoomDatabase.getDatabase(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.load_b:
                onLoadButtonPressed();
                break;
        }
    }


    /** Button zum Laden der Hofautomaten */
    public void onLoadButtonPressed() {
        final ListView listView = (ListView) findViewById(R.id.listview);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                //Alle Hofautomaten in Liste speichern
                final List<Hofautomat> alleAutomaten = db.hofautomatDAO().getAll();
                final List<Integer> alleFavoriten = db.favoritDAO().findFavoritForUserByUserId(1);
                final Favorit favorit = new Favorit();

                //Lade die Namen der Hofautomaten
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final ArrayList<String> listNamen = new ArrayList<String>();
                        final ArrayList<String> listAdressen = new ArrayList<>();
                        final ArrayList<Integer> listIds = new ArrayList<>();

                        for(int i = 0; i < alleAutomaten.size(); ++i){
                            listIds.add(alleAutomaten.get(i).getId());
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

                        // Create a BaseAdapter instance.
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
                                    itemView = LayoutInflater.from(HomescreenActivity.this).inflate(R.layout.activity_listview_baseadapter, null);
                                }

                                // Find related view object inside the itemView.
                                //ImageView imageView = (ImageView)itemView.findViewById(R.id.baseUserImage);
                                TextView nameView = (TextView)itemView.findViewById(R.id.name);
                                TextView adressView = (TextView)itemView.findViewById(R.id.adresse);

                                // Set resources.
                                //imageView.setImageResource(R.mipmap.ic_launcher);

                                final String name = listNamen.get(itemIndex);
                                final String adresse = listAdressen.get(itemIndex);
                                final int id = listIds.get(itemIndex);
                                nameView.setText(name);
                                adressView.setText(adresse);

                                // Find the button in list view row.
                               Button itemButton = (Button)itemView.findViewById(R.id.buttonFav);
                                itemButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //ToDo: Abfragen, ob es Favoriten bereits gibt
                                        //funktioniert noch nicht
                                        if(alleFavoriten.contains(id)){
                                            Toast.makeText(HomescreenActivity.this, "Diesen Hofautomaten haben Sie bereits als Favorit", Toast.LENGTH_SHORT).show();
                                        } else {
                                            favorit.setUserId(1);
                                            favorit.setHofautomatId(id);
                                            db.favoritDAO().insertFavorit(favorit);
                                            Toast.makeText(HomescreenActivity.this, "Sie haben " + name + " zu Ihren Favoriten hinzugefügt ", Toast.LENGTH_SHORT).show();
                                        }
                                        /*for (int i = 0; i < alleFavoriten.size(); i++) {
                                            if (alleFavoriten.get(i).equals(id)) {
                                                Toast.makeText(HomescreenActivity.this, "Diesen Hofautomaten haben Sie bereits als Favorit", Toast.LENGTH_SHORT).show();
                                                break;
                                            }
                                        }
                                                favorit.setUserId(1);
                                                favorit.setHofautomatId(id);
                                                db.favoritDAO().insertFavorit(favorit);
                                                Toast.makeText(HomescreenActivity.this, "Sie haben " + name + " zu Ihren Favoriten hinzugefügt ", Toast.LENGTH_SHORT).show();
                                        */


                                    }
                                });

                                return itemView;
                            }
                        };

                        listView.setAdapter(customBaseAdapter);
                    }
                });
            }
        });
    }

    /** Called when the user taps the Filter button */
    public void openFilter(View view) {
        Intent intent = new Intent(this, FilterActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Favoriten button */
    public void openFavoriten(View view) {
        Intent intent = new Intent(this, FavoritenActivity.class);
        startActivity(intent);
    }
}