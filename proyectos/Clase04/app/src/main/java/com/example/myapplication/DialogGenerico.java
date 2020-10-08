package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogGenerico extends DialogFragment {
    //Fragment son porciones de activity

    //Armar una clase de dato genérica para que se puedan pasar parámetros por constructor

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Alta persona");
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.alta_persona, null);
        //builder.setView(R.layout.alta_persona); //para +21
        builder.setView(view);

        /*builder.setMessage("Hola!!");
        ClickDialogGenerico clickDialogGenerico = new ClickDialogGenerico();
        builder.setNeutralButton("Neutral", clickDialogGenerico);
        builder.setPositiveButton("Positive", clickDialogGenerico);
        builder.setNegativeButton("Negative", clickDialogGenerico);
        */
        return builder.create();
    }
}
