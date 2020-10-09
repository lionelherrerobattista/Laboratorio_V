package com.example.practicapp;

import android.app.Activity;
import android.media.Image;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder {

    public TextView tvNombre;
    public TextView tvCantidadProd;
    public TextView tvPrecioProd;
    public ImageButton btnEditar;
    public ImageButton btnPlus;
    public ImageButton btnMinus;


    public ProductoViewHolder(@NonNull View itemView) {
        super(itemView);
        //TextViews
        this.tvNombre = itemView.findViewById(R.id.tvNombre);
        this.tvCantidadProd = itemView.findViewById(R.id.tvCantidadProd);
        this.tvPrecioProd = itemView.findViewById(R.id.tvPrecioProd);

        //Botones
        this.btnEditar = itemView.findViewById(R.id.btnEditar);
        this.btnPlus = itemView.findViewById(R.id.btnPlus);
        this.btnMinus = itemView.findViewById(R.id.btnMinus);


    }
}
