package com.example.primerparciallabov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Producto> listaProductos;
    private ProductoAdapter productoAdapter;
    private Producto producto;
    private int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear lista de productos
        List<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Producto("mesa", 5, 150d ));
        listaProductos.add(new Producto("silla", 20, 50.5));
        listaProductos.add(new Producto("sillón", 10, 300d));
        listaProductos.add(new Producto("escritorio", 15, 500d));
        listaProductos.add(new Producto("lámpara", 35, 250d));
        listaProductos.add(new Producto("cama", 15, 700d));
        listaProductos.add(new Producto("televisión", 10, 2000d));
        listaProductos.add(new Producto("computadora", 15, 2500d));
        listaProductos.add(new Producto("estufa", 3, 600d));
        listaProductos.add(new Producto("biblioteca", 16, 400d));
        listaProductos.add(new Producto("monitor", 12, 1000d));
        listaProductos.add(new Producto("impresora", 20, 800d));

        this.listaProductos = listaProductos;

        //Recuperar el recycler de la View
        RecyclerView recyclerView = findViewById(R.id.recycler);

        //Setear manera de representar la lista
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Crear el adapter y pasarle la lista y pasarsela al adapter
        ProductoAdapter productoAdapter = new ProductoAdapter(listaProductos, this);
        this.productoAdapter = productoAdapter;
        recyclerView.setAdapter(this.productoAdapter);

    }


    public void editarProducto(int posicion) {


        //intención de abrir una segunda activity:
        Intent i = new Intent(this, EditarProductoActivity.class);
        //Guardar producto y posicion
        this.producto = this.listaProductos.get(posicion);
        this.posicion = posicion;


        //Pasar datos:
        i.putExtra("nombre", this.producto.getNombre());
        i.putExtra("precio", this.producto.getPrecio().doubleValue());
        i.putExtra("cantidad", this.producto.getCantidad().intValue());
        startActivityForResult(i, 1);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {

                String nombre = data.getStringExtra("nombre");
                Integer cantidad = data.getIntExtra("cantidad", 0);
                Double precio = data.getDoubleExtra("precio", 0);

                this.producto.setNombre(nombre);
                this.producto.setCantidad(cantidad);
                this.producto.setPrecio(precio);

                this.productoAdapter.notifyItemChanged(this.posicion);
            }
        }
    }
}