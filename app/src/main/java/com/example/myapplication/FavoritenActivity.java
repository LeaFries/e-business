package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Entitys.Adresse;
import com.example.myapplication.Entitys.Favorit;
import com.example.myapplication.Entitys.Hofautomat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class FavoritenActivity extends AppCompatActivity { URoomDatabase db;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoriten);

        db = URoomDatabase.getDatabase(this);

        final ListView listView = (ListView) findViewById(R.id.listViewFavoriten);

        final List<Integer> hofautomatIds = db.favoritDAO().findFavoritForUserByUserId(1);
        ArrayList<Hofautomat> alleAutomaten = new ArrayList<>();


        for(int i = 0; i < hofautomatIds.size(); ++i) {
            Hofautomat hofautomat = db.hofautomatDAO().findHofautomatById(hofautomatIds.get(i));
            alleAutomaten.add(hofautomat);
        }

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
                    itemView = LayoutInflater.from(FavoritenActivity.this).inflate(R.layout.activity_listview_baseadapter, null);
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
                        db.favoritDAO().deleteFavoritByHofautomatId(id);
                        Toast.makeText(FavoritenActivity.this, "Sie haben " + name + " von Ihren Favoriten entfernt ", Toast.LENGTH_SHORT).show();

                    }
                });

                return itemView;
            }
        };

        listView.setAdapter(customBaseAdapter);
    }

    /** Called when the user taps the Homescreen button */
    public void openHomescreen(View view) {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);
    }
}