package com.example.clase06;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EjecutarHttp extends Thread {

    public Handler handler;

    public EjecutarHttp(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run(){
        //Poner lo que queremos que se ejecute en paralelo
        ConexionHttp con = new ConexionHttp();
        //Recuperar la respuesta
        String json = con.obtenerRespuesta("https://restcountries.eu/rest/v2/region/europe");
        //Parsear JSON acá
        //Enviar el mensaje
        Message mensaje = new Message();
        try {
            mensaje.obj = generarListaString(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.handler.sendMessage(mensaje);
    }

    private List<String> generarListaString(String json) throws JSONException {
        List<String> paises = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);

        //Recorrer el json
        for(int i=0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            //Gaurdar el objeto en el array
            paises.add((object.getString("name")));
        }
        return paises;
    }
}
