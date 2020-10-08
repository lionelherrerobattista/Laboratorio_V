package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        //Crear las opciones del menú
        getMenuInflater().inflate(R.menu.menu, menu);

        //Recuperar los datos enviados
        Bundle bundle = super.getIntent().getExtras();
        TextView tvNom = super.findViewById(R.id.nombreTxt);
        TextView tvTel = super.findViewById(R.id.telefono);
        Button btnLlamar = super.findViewById(R.id.llamar);
        LlamarTelefonoClick llamarTelefonoClick = new LlamarTelefonoClick(this, bundle.getInt("Telefono"));
        btnLlamar.setText("Llamar");

        btnLlamar.setOnClickListener(llamarTelefonoClick);

        tvNom.setText(bundle.getString("Nombre"));
        tvTel.setText(bundle.getInt("Telefono")+"");

        Log.d("nombre intent",bundle.getString("Nombre"));
        Log.d("telefono intent", bundle.getInt("Telefono") + "");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
       /* if(R./i)*/
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}