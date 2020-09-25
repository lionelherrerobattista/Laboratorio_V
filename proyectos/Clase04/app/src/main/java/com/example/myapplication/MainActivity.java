package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    List<Persona> personas;
    PersonaAdapter personaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear lista
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", "Pérez"));
        personas.add(new Persona("María", "López"));
        personas.add(new Persona("José", "Gonzalez"));
        personas.add(new Persona("Laura", "Sánchez"));
        this.personas = personas;

        //Crear adapter
        this.personaAdapter = new PersonaAdapter(personas, this);

        RecyclerView rc = super.findViewById(R.id.recycler);
        rc.setAdapter(personaAdapter);

        //Setear la manera de representar la lista
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);

        //recupero el action bar para hacer visible el botón back
        ActionBar actionBar = super.getSupportActionBar(); //Es el menú
        actionBar.setTitle("Contactos");
        actionBar.setDisplayHomeAsUpEnabled(true); //muestro el botón de back
    }

    public void llamarPorTelefono(int posPersona) {
        Persona p = this.personas.get(posPersona);
        Log.d("Llamando a ", p.getApellido());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Recupero el xml como objeto java
        getMenuInflater().inflate(R.menu.menu, menu);

        //Guardo el texto a buscar
        MenuItem menuItem = menu.findItem(R.id.opSearch);//recuperamos el menu
        SearchView searchView = (SearchView) menuItem.getActionView(); //Le sacamos el action view
        searchView.setOnQueryTextListener(this); //le seteamos el listener

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(item.getItemId() == R.id.agregarPersona) {
            Intent i = new Intent(this, MainActivity2.class);
            startActivity(i);
        } else if(item.getItemId()==android.R.id.home) {
            //Se hizo click en el botón de home
            super.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("onQueryTextSubmit", query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //Setear una nueva lista al adapter con los datos reducidos
        List<Persona> listaFiltrada;
        String nombre;
        String apellido;

        listaFiltrada = new ArrayList<Persona>();

        //Filtrar la lista
        for(Persona p: personas) {
            nombre = p.getNombre();
            apellido = p.getApellido();

            if(nombre.contains(newText) || apellido.contains(newText)) {

                listaFiltrada.add(p);

            }
        }
        //Pasarle al adapter por set la lista
        this.personaAdapter.setPersonas(listaFiltrada);
        //Hacer el notify para que el adapter registre el cambio
        this.personaAdapter.notifyDataSetChanged();
        Log.d("onQueryTextChange", newText);

        return false;
    }
}