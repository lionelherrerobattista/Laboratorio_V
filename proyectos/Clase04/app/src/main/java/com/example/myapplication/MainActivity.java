package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear lista
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Nombre1", "Apellido1"));
        personas.add(new Persona("Nombre2", "Apellido2"));
        personas.add(new Persona("Nombre3", "Apellido3"));
        personas.add(new Persona("Nombre4", "Apellido4"));

        //Crear adapter
        PersonaAdapter personaAdapter = new PersonaAdapter(personas);
        RecyclerView rc = super.findViewById(R.id.recycler);
        rc.setAdapter(personaAdapter);

        //Setear la manera de representar la lista
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);
    }
}