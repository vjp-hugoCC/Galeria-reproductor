package com.example.pruebagaleria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebagaleria.adaptadores.ListaCancionesAdapter;
import com.example.pruebagaleria.entidades.Canciones;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListaCancionesAdapter.OnCancionListener {
    private RecyclerView listaCanciones;
    Switch formato;
    private ArrayList<Canciones> listaArrayCanciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //captura elementos
        formato = findViewById(R.id.switch_formato);

        listaCanciones=findViewById(R.id.listaCanciones);
        listaCanciones.setLayoutManager(new LinearLayoutManager(this));
        listaArrayCanciones=new ArrayList<>();
        //cargar todas las canciones al array de canciones

        ListaCancionesAdapter adapter=new ListaCancionesAdapter(listaArrayCanciones,this);
        listaCanciones.setAdapter(adapter);
    }

    @Override
    public void onCancionClick(int posicion) {
        if(formato.isChecked()){
            Intent intent=new Intent(this,VideoActivity.class);
            intent.putExtra("cancion",listaArrayCanciones.get(posicion));
            startActivity(intent);
        }else{
            Intent intent=new Intent(this,AudioActivity.class);
            intent.putExtra("cancion",listaArrayCanciones.get(posicion));
            startActivity(intent);
        }
    }
}