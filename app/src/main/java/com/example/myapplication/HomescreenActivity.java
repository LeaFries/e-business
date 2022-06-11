package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Entitys.Hofautomat;
import com.example.myapplication.Entitys.Produkt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomescreenActivity  extends AppCompatActivity implements View.OnClickListener {
    URoomDatabase db;
    private AppCompatButton loadButton;
    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        loadButton = findViewById(R.id.load_b);
        nameTextView = findViewById(R.id.textView10);


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

    public void onSaveButtonPressed() {
    }


    /** Button zum Laden der Hofautomaten */
    public void onLoadButtonPressed() {
        final ListView listView = (ListView) findViewById(R.id.listview);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                //Test: zuletzt gespeicherten Hofautomaten aus Datenbank holen
                final Hofautomat hofautomat = db.hofautomatDAO().getLastHofautomat();
                final List<String> automaten = db.hofautomatDAO().getHofautomatNames();

                //Lade den Namen in die TextView
                /**  runOnUiThread(new Runnable() {
                @Override public void run() {
                nameTextView.setText(hofautomat.getName());
                }
                });*/

                //Lade den Namen in die TextView
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final ArrayList<String> list = new ArrayList<String>();
                        for(int i = 0; i < automaten.size(); ++i){
                            list.add(automaten.get(i));
                        }
                        final StableArrayAdapter arrayAdapter = new StableArrayAdapter(getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                list);
                        listView.setAdapter(arrayAdapter);
                    }
                });
            }
        });
    }
    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

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