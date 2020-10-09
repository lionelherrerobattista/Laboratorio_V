package com.example.practicapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

public class EjecutarAccionClick implements View.OnClickListener {

    MainActivity mainActivity; //Para llamar al método
    int posicion; //posición del item de la lista que selecciona el usuario

    public EjecutarAccionClick(MainActivity activity, int posicion) {
        this.mainActivity = activity;
        this.posicion = posicion;
    }

    @Override
    public void onClick(View v) {

        //Identificar el boton presionado
        //Utilizar la View para recuperar los id !!
        switch (v.getId()) {
            case R.id.btnEditar:
                this.mainActivity.controlStock("editar", posicion);
                break;
            case R.id.btnPlus:
                this.mainActivity.controlStock("plus", posicion);
                break;
            case R.id.btnMinus:
                this.mainActivity.controlStock("minus", posicion);
                break;
        }

    }
}
