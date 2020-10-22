package com.example.primerparciallabov;

import android.widget.Button;
import android.widget.EditText;

public class ProductoView {
    EditarProductoActivity editarProductoActivity;
    Producto producto;

    public ProductoView(EditarProductoActivity editarProductoActivity, Producto producto) {
        this.editarProductoActivity = editarProductoActivity;
        this.producto = producto;
    }

    public void cargarPantalla() {
        //Recuperar elementos
        EditText edNombre = this.editarProductoActivity.findViewById(R.id.edNombre);
        EditText edCantidad = this.editarProductoActivity.findViewById(R.id.edCantidadProd);
        EditText edPrecio = this.editarProductoActivity.findViewById(R.id.edPrecioProd);
        Button btnEditar = this.editarProductoActivity.findViewById(R.id.btnEditar);
        EditarClick editarClick = new EditarClick(this.editarProductoActivity);
        btnEditar.setOnClickListener(editarClick);

        edNombre.setText(this.producto.getNombre());
        edCantidad.setText(this.producto.getCantidad().toString());
        edPrecio.setText(this.producto.getPrecio().toString());
    }
}
