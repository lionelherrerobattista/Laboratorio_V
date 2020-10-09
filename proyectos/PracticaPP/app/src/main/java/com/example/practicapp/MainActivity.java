package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  List<Producto> listaProductos;
    private ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Producto("mesa", 5, 150));
        listaProductos.add(new Producto("silla", 20, 50.5));
        listaProductos.add(new Producto("sillón", 10, 300));

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

    /**
     * Realiza la acción que se pasa por parámetro en el item de la posición indicada
     * @param accion acción que se va a realizar según el botón presionado
     * @param posicion posición del item seleccionado
     */
    public void controlStock(String accion, int posicion) {

        Producto producto = this.listaProductos.get(posicion);

        switch (accion) {
            case "editar":
                //Generar el dialog genérico
                //Pasar el producto, la posición y el Main Activity para llamar al método actualizar
                DialogGenerico dialogGenerico = new DialogGenerico(producto, posicion, this);
                dialogGenerico.show(getSupportFragmentManager(), "editar");
                break;
            case "plus":
                producto.setCantidad(producto.getCantidad() + 1);
                this.actualizarItem(posicion);
                break;
            case "minus":
                producto.setCantidad(producto.getCantidad() - 1);
                this.actualizarItem(posicion);
                break;
        }

    }


    /**
     * Actualiza solo el item que se seleccionó
     * @param posicion la posición del item que se va a actualizar
     */
    public void actualizarItem(int posicion) {
        this.productoAdapter.notifyItemChanged(posicion); //Actualiza un solo item del recycler
    }
}