package com.example.primerparciallabov;

import android.view.View;

public class EditarClick implements View.OnClickListener {

    EditarProductoActivity editarProductoActivity;

    public EditarClick(EditarProductoActivity editarProductoActivity) {
        this.editarProductoActivity = editarProductoActivity;
    }

    @Override
    public void onClick(View v) {

        this.editarProductoActivity.enviarDatos();

    }
}
