package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Entitys.Hofautomat;

import java.util.ArrayList;
import java.util.List;

public class HomescreenActivity  extends AppCompatActivity {
    URoomDatabase db;
    private TextView nameTextView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        db = URoomDatabase.getDatabase(this);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

               // final ArrayList<String> hofautomaten = db.hofautomatDAO().getHofautomatNames();
                final Hofautomat hofautomat = db.hofautomatDAO().getLastHofautomat();

                //Lade den Namen in die TextView
               runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       //nameTextView.setText(hofautomat.getName());
                        //listView = (ListView)findViewById(R.id.listView);
                       /* final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                                R.layout.activity_listview,
                                hofautomaten);
                        listView.setAdapter(arrayAdapter); */
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