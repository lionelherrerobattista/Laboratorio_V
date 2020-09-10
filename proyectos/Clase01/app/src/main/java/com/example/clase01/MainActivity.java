package com.example.clase01;

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

        //Recuperar el botón y el edit por id
        Button btn = super.findViewById(R.id.btn);
        Button btnC = super.findViewById(R.id.btnC);
        TextView tv = super.findViewById(R.id.tv);
        //EditText ed = super.findViewById(R.id.ed); //Quizás no se use, paso activity como param
        //Si no se usa mucho mejor no crearlo
        btnC.setText(getString(R.string.bye));


        MyListener listener = new MyListener(this, tv); //Le paso la activity (this)...
        // ...para recuperar el elemento (contexto)
        btn.setOnClickListener(listener);
        btnC.setOnClickListener(listener); //le seteo el mismo listener

        String s = tv.getText().toString();
        tv.setText("Hola desde JAVA");
    }





}