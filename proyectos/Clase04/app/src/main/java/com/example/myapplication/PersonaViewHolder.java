package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder {
    public TextView tvApellido;
    public TextView tvNombre;
    public PersonaViewHolder(@NonNull View itemView) {
        super(itemView);
        //Guardo los text view para no repetir
        this.tvNombre = itemView.findViewById(R.id.txtNombre);
        this.tvApellido = itemView.findViewById(R.id.txtApellido);
    }
}
