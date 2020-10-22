package com.example.clase06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generar el handler
        Handler handler = new Handler(this);
        //Ejecutar el hilo
        EjecutarHttp miHilo = new EjecutarHttp(handler);
        //Ejecutar metodo start()
        miHilo.start();
        Log.d("Main", "Termino el onCreate!");
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        TextView tvRespuesta = findViewById(R.id.tvRespuesta);
        //Obtener el mensaje y castear la lista
        List<String> lista = (List<String>)  msg.obj;
        tvRespuesta.setText(lista.get(7));

        return false;
    }
}