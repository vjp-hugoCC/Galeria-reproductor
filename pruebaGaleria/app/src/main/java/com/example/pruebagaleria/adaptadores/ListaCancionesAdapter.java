package com.example.pruebagaleria.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebagaleria.R;
import com.example.pruebagaleria.entidades.Canciones;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListaCancionesAdapter extends RecyclerView.Adapter<ListaCancionesAdapter.CancionViewHolder> {

    ArrayList<Canciones> listaCanciones;
    public ListaCancionesAdapter(ArrayList<Canciones> listaCanciones){
        this.listaCanciones=listaCanciones;
    }

    @NonNull
    @Override
    public CancionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cancion_item,null,false);
        return new CancionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CancionViewHolder holder, int position) {
        holder.viewNombre.setText(listaCanciones.get(position).getNombre());
        holder.viewAutor.setText(listaCanciones.get(position).getAutor());
        Picasso.get().load(listaCanciones.get(position).getImagen()).error(R.mipmap.ic_launcher_round).into(holder.viewImagen);
    }

    @Override
    public int getItemCount() {
        return listaCanciones.size();
    }

    public class CancionViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewAutor;
        ImageView viewImagen;

        public CancionViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre=itemView.findViewById(R.id.textViewCancion);
            viewAutor=itemView.findViewById(R.id.textViewAutores);
            viewImagen=itemView.findViewById(R.id.imageView);
        }
    }
}
