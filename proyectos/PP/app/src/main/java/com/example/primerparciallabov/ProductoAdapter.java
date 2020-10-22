package com.example.primerparciallabov;

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

        this.listaProductos = listaProductos;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Crear la view y el viewHolder y devolverlos
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                parent, false);
        ProductoViewHolder productoViewHolder = new ProductoViewHolder(v, this.mainActivity);

        return productoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        //Setear los elementos de la view con los datos del objeto
        Producto producto = listaProductos.get(position); //uso la posición para encontrar el item
        holder.posicion = position;
        //TODO pasar a string los valores
        holder.tvNombre.setText(producto.getNombre().substring(0,1).toUpperCase()
                + producto.getNombre().substring(1));
        holder.tvCantidadProd.setText(Integer.valueOf(producto.getCantidad()).toString());
        holder.tvPrecioProd.setText(Double.valueOf(producto.getPrecio()).toString());

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }
}
