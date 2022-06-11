package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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
import java.util.List;

public class HomescreenActivity  extends AppCompatActivity implements View.OnClickListener {
    URoomDatabase db;
    private AppCompatButton loadButton;
    private TextView nameTextView;
    private ListView listView;

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
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                //Test: zuletzt gespeicherten Hofautomaten aus Datenbank holen
                final Hofautomat hofautomat = db.hofautomatDAO().getLastHofautomat();

                //Lade den Namen in die TextView
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        nameTextView.setText(hofautomat.getName());
                    }
                });
            }
            //Lade den Namen in die TextView
           /** runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //nameTextView.setText(hofautomat.getName());
                    //listView = (ListView)findViewById(R.id.listView);
                       /* final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                                R.layout.activity_listview,
                                hofautomaten);
                        listView.setAdapter(arrayAdapter);
                }
            });*/
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