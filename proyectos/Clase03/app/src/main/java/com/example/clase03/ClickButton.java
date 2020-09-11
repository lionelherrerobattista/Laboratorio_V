package com.example.clase03;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ClickButton implements View.OnClickListener {

    PersonaView view;
    PersonaModel modelo;

    public ClickButton(PersonaView view, PersonaModel modelo) {
        this.view = view;
        this.modelo = modelo;
    }

    @Override
    public void onClick(View v) {

        //Cargo el modelo
        this.view.cargarModelo();

        Log.d("Persona Ingresada", this.modelo.toString());

    }
}
