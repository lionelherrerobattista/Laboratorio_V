package com.example.practicaparcial2;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class EjecutarHttp extends Thread {

    public String url;
    public Handler handler;

    public EjecutarHttp(Handler handler, String url) {
        this.url = url;
        this.handler = handler;
    }

    @Override
    public void run(){
        //Poner lo que queremos que se ejecute en paralelo
        ConexionHttp con = new ConexionHttp();

        //Recuperar la respuesta
        String json = con.obtenerRespuesta(this.url);

        //Cargar el mensaje que se devuelve
        Message mensaje = new Message();
        mensaje.arg1=1;
        mensaje.obj = json;

        Log.d("mensaje", json);
        this.handler.sendMessage(mensaje);
    }

}
