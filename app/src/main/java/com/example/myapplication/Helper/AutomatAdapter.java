package com.example.myapplication.Helper;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.Entitys.Produkt;
import com.example.myapplication.R;

import java.util.List;

import com.example.myapplication.Entitys.Hofautomat;


public class AutomatAdapter extends ArrayAdapter<Hofautomat>{

        public AutomatAdapter(@NonNull Context context, int resource, List<Hofautomat> produktList) {
            super(context, resource, produktList);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Hofautomat hofautomat = getItem(position);

            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.produkt_cell, parent, false);
                TextView tv = (TextView) convertView.findViewById(R.id.produktName);
                //TextView tv2 = (TextView) convertView.findViewById(R.id.produktBeschreibung);



                tv.setText(hofautomat.getName());

            }
            return convertView;
        }
}
