package com.example.practicapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogGenerico extends DialogFragment {

    Producto producto;
    MainActivity mainActivity;
    int posicion;


    public DialogGenerico(Producto producto, int posicion, MainActivity mainActivity) {
        this.producto = producto;
        this.posicion = posicion;
        this.mainActivity = mainActivity;

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View viewDialogo = layoutInflater.inflate(R.layout.layout_dialogo, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Editar nombre");
        builder.setView(viewDialogo);

        //Tomar el editText
        EditText etNombre  = viewDialogo.findViewById(R.id.etNombre);

        //Crear los botones y asignar el evento
        ClickDialogGenerico clickDialogGenerico = new ClickDialogGenerico(producto, etNombre,
                posicion, mainActivity);
        builder.setPositiveButton("Positive", clickDialogGenerico);
        builder.setNegativeButton("Negative", clickDialogGenerico);

        return builder.create();
    }
}
