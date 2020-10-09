package com.example.practicapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.EditText;

public class ClickDialogGenerico implements DialogInterface.OnClickListener {

    //todo pasar al main como variable global posicion y producto (?)
    int posicion; //Para pasársela al método
    Producto producto; //Para cambiar los datos
    EditText etNombre; //Para recuperar el input del usuario y actualizar el producto
    MainActivity mainActivity;

    public ClickDialogGenerico(Producto producto, EditText etNombre, int posicion,
                               MainActivity mainActivity) {
        this.producto = producto;
        this.etNombre = etNombre;
        this.posicion = posicion;
        this.mainActivity = mainActivity;

    }


    @Override
    public void onClick(DialogInterface dialog, int which) {

        if(which == Dialog.BUTTON_POSITIVE) {
            //Cambiar el nombre y actualizar el item
            producto.setNombre(etNombre.getText().toString());
            this.mainActivity.actualizarItem(this.posicion);
        } else if(which == Dialog.BUTTON_NEGATIVE) {
            dialog.dismiss();
        }

    }
}
