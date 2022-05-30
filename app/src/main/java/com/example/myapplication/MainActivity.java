package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.example.myapplication.Entitys.Produkt;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    URoomDatabase db;
    private AppCompatButton saveButton, loadButton;
    private TextView nameTextView;

    public static final String OUTER_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = findViewById(R.id.save_button);
        loadButton = findViewById(R.id.load_button);
        nameTextView = findViewById(R.id.textView);

        saveButton.setOnClickListener(this);
        loadButton.setOnClickListener(this);

        db = URoomDatabase.getDatabase(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_button:
                onSaveButtonPressed();
                break;
            case R.id.load_button:
                onLoadButtonPressed();
                break;

        }

    }

    public void onSaveButtonPressed() {
        //Neuen Namen erstellen
        final Produkt newProdukt = new Produkt();
        //DB Objekt mit Daten füttern
        newProdukt.setName("Beispiel");
        newProdukt.setPreis(3.0);
        newProdukt.setBeschreibung("Beschreibung");

        //Namen mit Hilfe der entsprechenden DAO Schnittstelle in DB einfügen.
        //Alle Interaktionen mit der Datenbank müssen asynchron in einem eigenen
        //Thread ausgeführt werden, da sie sonst die Usablity stark beinträchtigen.
        //Room bestraft uns mit einem Crash, falls wir gegen diese Regel verstoßen.
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                db.produktDAO().insertProdukt(newProdukt);
            }
        });
    }

    public void onLoadButtonPressed() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                //zuletzt gespeicherten Namen aus Datenbank holen
                final Produkt oldProdukt = db.produktDAO().getLastProdukt();

                //Lade den Namen in die TextView
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        nameTextView.setText(oldProdukt.getName());
                    }
                });
            }
        });
    }
}