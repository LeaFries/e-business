package com.example.myapplication.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Entitys.Produkt;
import com.example.myapplication.R;

import java.util.List;

public class ProduktAdapter extends ArrayAdapter<Produkt>
{

    public ProduktAdapter(@NonNull Context context, int resource, List<Produkt> produktList) {
        super(context, resource, produktList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produkt produkt = getItem(position);

        if(convertView == null){
            LayoutInflater.from(getContext()).inflate(R.layout.produkt_cell, parent, false);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.produktName);
        TextView tv2 = (TextView) convertView.findViewById(R.id.produktBeschreibung);

        tv.setText(produkt.getName());
        tv2.setText(produkt.getBeschreibung());

        return convertView;
    }
}
