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

        TextView entfernungValue = findViewById(R.id.entfernungValue);

        RangeSlider entfernungSlider = findViewById(R.id.entfernungSlider);
        entfernungSlider.addOnChangeListener((slider, value, fromUser) -> {
            int intValue = (int) Math.round(value);
            entfernungValue.setText(Integer.valueOf(intValue) + " km");
                }
        );
    }

    /** Called when the user taps the Suche button */
    public void tapsOnFilter(View view) {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);
    }


}