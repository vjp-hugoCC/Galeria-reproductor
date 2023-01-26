package com.example.pruebagaleria;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebagaleria.adaptadores.ListaCancionesAdapter;
import com.example.pruebagaleria.entidades.Canciones;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listaCanciones;
    private ArrayList<Canciones> listaArrayCanciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCanciones=findViewById(R.id.listaCanciones);
        listaCanciones.setLayoutManager(new LinearLayoutManager(this));
        listaArrayCanciones=new ArrayList<>();
        //cargar todas las canciones al array
        Canciones cancion1=new Canciones(1,"normal", "feid","https://yt3.googleusercontent.com/GUW78kIdMM2mVjl-c1rkSD8DqNYSRZAfTUTie3j4xKFN6agTpdb9UiMDGwQB2yuoDpKB1a8QNn8=s900-c-k-c0x00ffffff-no-rj","" );
        Canciones cancion2=new Canciones(2,"ferxxo100", "feid","https://img-s-msn-com.akamaized.net/tenant/amp/entityid/AA12d21e.img?h=0&w=600&m=6&q=60&u=t&o=f&l=f&x=303&y=159","" );
        listaArrayCanciones.add(cancion1);
        listaArrayCanciones.add(cancion2);
        ListaCancionesAdapter adapter=new ListaCancionesAdapter(listaArrayCanciones);
        listaCanciones.setAdapter(adapter);
    }

}