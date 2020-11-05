package com.example.clase06;

import android.os.Handler;
import android.os.Message;
import android.util.Xml;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class EjecutarHttp extends Thread {

    public Handler handler;
    public boolean esImagen;
    public String url;

    public EjecutarHttp(Handler handler, boolean esImagen, String url) {

        this.handler = handler;
        this.esImagen = esImagen;
        this.url = url;
    }

    @Override
    public void run(){
        //Poner lo que queremos que se ejecute en paralelo
        ConexionHttp con = new ConexionHttp();

        if(esImagen) {
            byte[] imagen = con.obtenerRespuestaImg(url);
            Message message = new Message();
            message.arg1=3;
            message.obj=imagen;
            this.handler.sendMessage(message);

        }else {
            //Recuperar la respuesta
            //String json = con.obtenerRespuesta("https://restcountries.eu/rest/v2/region/europe");
            String xml = con.obtenerRespuesta("https://www.clarin.com/rss/lo-ultimo/");
            //Parsear JSON acá
            //Enviar el mensaje
            Message mensaje = new Message();
            mensaje.arg1=2;
            mensaje.obj = parserNoticiaByXML(xml);
        /*try {
            //mensaje.obj = generarListaString(json);
            mensaje.obj = parserNoticiaByXML(xml);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
            this.handler.sendMessage(mensaje);
        }
    }

    private List<Noticia> parserNoticiaByXML (String xml) {
        List<Noticia> noticias = new ArrayList<>();
        XmlPullParser parser = Xml.newPullParser();
        try {
            parser.setInput(new StringReader(xml));
            //Iteramos sobre el documento para ir sacando la información
            //Se trabaja con event type 4 tipos
            int evento = parser.getEventType();
            Noticia n= null;
            while(evento != XmlPullParser.END_DOCUMENT){
                if(evento==XmlPullParser.START_TAG) {
                    //Sacamos el nombre de la etiqueta
                    String nombreTag = parser.getName();
                    if("title".equals(nombreTag) && n!=null) {
                        //Lo que está entre los tags, lo guardamos
                        n.titulo = parser.nextText();
                    }else if("item".equals(nombreTag)) {
                        n = new Noticia();
                    }else if("description".equals(nombreTag) && n!=null) {
                        n.descripcion = parser.nextText();
                    }else if("link".equals(nombreTag) && n!=null) {
                        n.link = parser.nextText();
                    }else if("enclosure".equals(nombreTag) && n!=null){
                        //Para sacar la imagen
                        n.urlImg = parser.getAttributeValue(null, "url");
                    }
                }else if (evento == XmlPullParser.END_TAG){
                    String nombreTag = parser.getName();
                    if("item".equals(nombreTag)) {
                        noticias.add(n);
                    }
                }
                //Que avance al siguiente evento
                evento = parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  noticias;
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
