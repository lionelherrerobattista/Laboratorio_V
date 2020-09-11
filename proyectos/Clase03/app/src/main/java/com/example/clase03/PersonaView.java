package com.example.clase03;

import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PersonaView {
    //Elementos de la pantalla
    MainActivity activity;
    PersonaModel modelo;


    public PersonaView(MainActivity activity, PersonaModel modelo) {
        this.activity = activity;
        this.modelo = modelo;
    }

    //Recupero todos los findViewById
    public void cargarModelo() {
        EditText edNombre = activity.findViewById(R.id.nombre);
        EditText edApellido = activity.findViewById(R.id.apellido);
        EditText edDni = activity.findViewById(R.id.dni);
        RadioGroup rgSexo = activity.findViewById(R.id.sexo);

        int radioId = rgSexo.getCheckedRadioButtonId();
        Log.d("id:", Integer.toString(radioId));
        RadioButton rbSexo = activity.findViewById(radioId);
        String nombre = edNombre.getText().toString();
        String apellido = edApellido.getText().toString();
        Integer dni = Integer.parseInt(edDni.getText().toString());
        String sexo = rbSexo.getText().toString();

        this.modelo.setNombre(nombre);
        this.modelo.setApellido(apellido);
        this.modelo.setDni(dni);
        this.modelo.setSexo(sexo);

    }

    //cargo los textos
    public void cargarPantalla() {
        EditText etNombre = activity.findViewById(R.id.nombre);
        //etNombre.setText();
    }
}
