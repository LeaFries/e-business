package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;


      LatLng EierUndGeflügelHof= new LatLng(48.9299651090342, 8.36324570536428);
        map.addMarker(new MarkerOptions().position(EierUndGeflügelHof).title("EierUndGeflügelHof"));
        map.moveCamera(CameraUpdateFactory.newLatLng(EierUndGeflügelHof));

        LatLng Hedwighof = new LatLng(48.95822347253038, 8.430479613322998);
        map.addMarker(new MarkerOptions().position(Hedwighof).title("Hedwighof"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Hedwighof));


        LatLng LeonhardtHofautomat = new LatLng(48.94441521333429, 8.57907454642348);
        map.addMarker(new MarkerOptions().position(LeonhardtHofautomat).title("Leonhardt Hofautomat"));
        map.moveCamera(CameraUpdateFactory.newLatLng(LeonhardtHofautomat));



        //map.animateCamera(CameraUpdateFactory.zoomTo(7.0f));



    }
}