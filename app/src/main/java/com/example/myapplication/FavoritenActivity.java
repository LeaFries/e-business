package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FavoritenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoriten);
    }

    /** Called when the user taps the Homescreen button */
    public void openHomescreen(View view) {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);
    }
}