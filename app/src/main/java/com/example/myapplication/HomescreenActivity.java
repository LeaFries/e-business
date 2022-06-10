package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomescreenActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
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