package com.example.practicaparcial2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback, View.OnClickListener {
    Handler handler;
    String usuario;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Generar el handler
        this.handler = new Handler(this);

        //TODO comprobar las sharedpreferences
        SharedPreferences preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        this.usuario = preferences.getString("usuario", null);
        this.pass = preferences.getString("pass", null);


        if(this.usuario==null && this.pass==null) {
            Log.d("Usuario", "no hay usuario");
        } else {
            Log.d("Usuario", this.usuario);
            Log.d("pass", this.pass);

            DialogGenerico dialogGenerico = new DialogGenerico("Bienvenido","Hola " + this.usuario);
            dialogGenerico.show(getSupportFragmentManager(), "mensajeEjemplo");
        }

        //Tocar el botón y enviar la llamada http
        Button btn = findViewById(R.id.btnIngresar);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        EditText etUsuario = this.findViewById(R.id.etUsuario);
        EditText etPass= this.findViewById(R.id.etPass);

        this.usuario = etUsuario.getText().toString();
        this.pass = etPass.getText().toString();
        String url;

        //Ejecutar el hilo y preparar el http con los parámetros
        //TODO configurar permiso de internet!!
        url = "http://192.168.0.93:3000/loginUsuario?usr=" + this.usuario + "&pass=" + this.pass;

        //Recuperar los datos del usuario
        EjecutarHttp miHilo = new EjecutarHttp(this.handler, url);
        //Ejecutar el hilo
        miHilo.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {

        if(msg.obj.toString().equals("true")) {
            //Guardo en sharedpreferences
            SharedPreferences preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString("usuario", this.usuario);
            editor.putString("pass", this.pass);

            editor.commit();

            //TODO pasar a segunda activity

        } else {

            //Muestro mensaje de error
            DialogGenerico dialogGenerico = new DialogGenerico("Error", "Usuario o contraseña incorrectos");
            dialogGenerico.show(getSupportFragmentManager(), "mensajeEjemplo");
        }

        return false;
    }

}