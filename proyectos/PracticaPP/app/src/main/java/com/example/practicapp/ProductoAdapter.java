package com.example.practicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {

    private List<Producto> listaProductos;
    private MainActivity mainActivity;

    public ProductoAdapter(List<Producto> listaProductos, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Crear la view y el viewHolder y devolverlos
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                parent, false);
        ProductoViewHolder productoViewHolder = new ProductoViewHolder(v);

        return productoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        //Setear los elementos de la view con los datos del objeto
        Producto producto = listaProductos.get(position); //uso la posición para encontrar el item

        //TODO pasar a string los valores
        holder.tvNombre.setText(producto.getNombre());
        holder.tvCantidadProd.setText(Integer.valueOf(producto.getCantidad()).toString());
        holder.tvPrecioProd.setText(Double.valueOf(producto.getPrecio()).toString());

        //Pasar activity
        EjecutarAccionClick ejecutarAccionClick = new EjecutarAccionClick(this.mainActivity, position);

        //Setear los eventos

        holder.btnEditar.setOnClickListener(ejecutarAccionClick);
        holder.btnPlus.setOnClickListener(ejecutarAccionClick);
        holder.btnMinus.setOnClickListener(ejecutarAccionClick);

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }
}
