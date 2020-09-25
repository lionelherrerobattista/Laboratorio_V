package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;

public class MainActivity2 extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //recupero el action bar para hacer visible el botón back
        ActionBar actionBar = super.getSupportActionBar(); //Es el menú
        actionBar.setTitle("Agregar Persona");
        actionBar.setDisplayHomeAsUpEnabled(true); //muestro el botón de back
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if(R.i)
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}