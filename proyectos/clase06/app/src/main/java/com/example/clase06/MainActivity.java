package com.example.clase06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.ContentHandlerFactory;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    Handler handler;
    List<Noticia> noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //generar contexto
        SharedPreferences preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        String s = preferences.getString("user", null);
        Log.d("Usuario", "Usuario no configurado");

        if(s==null) {
            Intent i = new Intent(this, SinUserActivity.class);
            startActivity(i);
        } else {
            ActionBar actionBar = super.getSupportActionBar();
            actionBar.setTitle("Hola " + s);
        }

        //Generar el handler
        this.handler = new Handler(this);
        //Ejecutar el hilo
        EjecutarHttp miHilo = new EjecutarHttp(handler, false, "https://www.clarin.com/rss/lo-ultimo/");
        //Ejecutar metodo start()
        miHilo.start();
        Log.d("Main", "Termino el onCreate!");
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        TextView tvRespuesta = findViewById(R.id.tvRespuesta);
        //Obtener el mensaje y castear la lista
        /*
        List<String> lista = (List<String>)  msg.obj;
        tvRespuesta.setText(lista.get(7));*/

        //Muestro la noticia
        if(msg.arg1==2) {
            this.noticias = (List<Noticia>) msg.obj;
            Log.d("lista", String.valueOf(noticias.size()));
            tvRespuesta.setText(noticias.get(0).titulo);

            //Lanzo un nuevo hilo
            EjecutarHttp buscoImg= new EjecutarHttp(this.handler, true, noticias.get(0).urlImg);
            buscoImg.start();
        } else if(msg.arg1==3) {
            //Recupero el byte array
            byte[] img = (byte[]) msg.obj;
            ImageView imageView = this.findViewById(R.id.img);
            //Cargo la imagen
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(img, 0, img.length));
        }

        return false;
    }
}