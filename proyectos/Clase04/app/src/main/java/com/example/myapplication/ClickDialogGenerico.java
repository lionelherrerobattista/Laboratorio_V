package com.example.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.util.Log;

public class ClickDialogGenerico implements DialogInterface.OnClickListener {

    @Override
    public void onClick(DialogInterface dialog, int which) {
        //which -1, -2 o -3 --> indica el botón
        if(which == Dialog.BUTTON_POSITIVE){

        }
        Log.d("ClickDialog", "Se hizo click en " + which);
    }
}
