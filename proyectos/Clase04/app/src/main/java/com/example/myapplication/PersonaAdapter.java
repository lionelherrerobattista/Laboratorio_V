package com.example.myapplication;

import android.app.Person;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaViewHolder> {

    private List<Persona> personas;

    public PersonaAdapter(List<Persona> personas) {
        this.personas = personas;
    }


    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Representación de un item en estructura para el RecycleView
        //para cada view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,
                false); //el contexto es el dueño de los objetos
        PersonaViewHolder personaViewHolder = new PersonaViewHolder(v);

        return personaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        //Bindeamos los datos de la persona
        holder.tvNombre.setText(personas.get(position).getNombre());
        holder.tvApellido.setText(personas.get(position).getApellido());

    }

    @Override
    public int getItemCount() {
        return this.personas.size();
    }
}
