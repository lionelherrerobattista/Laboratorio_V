package com.example.clase03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonaModel personaModel = new PersonaModel();
        PersonaView personaView = new PersonaView(this, personaModel);
        ClickButton clickButton = new ClickButton(personaView, personaModel);


        Button btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(clickButton);


    }
}