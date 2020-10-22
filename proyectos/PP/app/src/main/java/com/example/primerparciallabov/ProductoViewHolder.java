package com.example.primerparciallabov;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView tvNombre;
    public TextView tvCantidadProd;
    public TextView tvPrecioProd;
    public MainActivity mainActivity;
    public int posicion;

    public ProductoViewHolder(@NonNull View itemView, MainActivity mainActivity) {
        super(itemView);
        //TextViews
        this.tvNombre = itemView.findViewById(R.id.tvNombre);
        this.tvCantidadProd = itemView.findViewById(R.id.tvCantidadProd);
        this.tvPrecioProd = itemView.findViewById(R.id.tvPrecioProd);
        this.mainActivity = mainActivity;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.mainActivity.editarProducto(this.posicion);
    }
}
