package com.example.myapplication;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
    public TextView tvApellido;
    public TextView tvNombre;
    public MainActivity activity;
    public int pos;

    public PersonaViewHolder(@NonNull View itemView, MainActivity activity) {
        super(itemView);
        //Guardo los text view para no repetir y hacer menos llamadas
        this.tvNombre = itemView.findViewById(R.id.txtNombre);
        this.tvApellido = itemView.findViewById(R.id.txtApellido);
        itemView.setOnClickListener(this);
        this.activity = activity;

    }

    @Override
    public void onClick(View v) {

        //Ejecuto la funcion para llamar
        this.activity.llamarPorTelefono(pos);

    }
}
