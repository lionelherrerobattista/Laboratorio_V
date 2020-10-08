package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LlamarTelefonoClick implements View.OnClickListener {
    private MainActivity2 mainActivity2;
    private int telefono;

    public LlamarTelefonoClick(MainActivity2 mainActivity2, int telefono){
        this.mainActivity2 = mainActivity2;
        this.telefono = telefono;
    }

    @Override
    public void onClick(View v) {
        //Hacer intent implícito
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+this.telefono));
        //Iniciar el intent
        //Preguntar si aceptó los permisos el usuario


        if(ContextCompat.checkSelfPermission(mainActivity2.getApplicationContext(), Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            mainActivity2.startActivity(callIntent);
        } else {
            //Pide los permisos
            ActivityCompat.requestPermissions(mainActivity2, new String[] {Manifest.permission.CALL_PHONE},1);
        }

    }
}
