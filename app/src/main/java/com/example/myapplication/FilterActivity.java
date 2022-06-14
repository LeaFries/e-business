package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Range;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;

import java.text.NumberFormat;
import java.util.Currency;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

    }

    /** Called when the user taps the Suche button */
    public void tapsOnFilter(View view) {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);
    }
    public void bierFilteredTapped(View view) {
    }

    public void milchFilteredTapped(View view) {
    }

    public void eierFilteredTapped(View view) {
    }

    public void kartoffelFilteredTapped(View view) {
    }

    public void wurstFilteredTapped(View view) {
    }

    public void brotFilteredTapped(View view) {
    }
}