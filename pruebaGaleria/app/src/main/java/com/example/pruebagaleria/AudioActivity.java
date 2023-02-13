package com.example.pruebagaleria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebagaleria.entidades.Canciones;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AudioActivity extends AppCompatActivity implements View.OnClickListener {
    private SeekBar progressBar;
    private ImageView portada;
    private ImageButton play_pause;
    private ImageButton previous;
    private ImageButton next;

    private TextView titulo;

    private TextView autores;

    private Boolean running;

    private ArrayList<Canciones> canciones;

    private int indiceCancion;

    MediaPlayer mPlayer;

    int duracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        //atributos
        running = true;
        canciones = (ArrayList<Canciones>) getIntent().getSerializableExtra("canciones");
        indiceCancion = getIntent().getExtras().getInt("indiceCancion");


        //captura
        progressBar = findViewById(R.id.seek_bar);
        portada = findViewById(R.id.portada);
        play_pause = findViewById(R.id.play_pause_button);
        play_pause.setOnClickListener(this);
        previous = findViewById(R.id.previous_button);
        previous.setOnClickListener(this);
        next = findViewById(R.id.next_button);
        next.setOnClickListener(this);
        titulo = findViewById(R.id.text_titulo);
        autores = findViewById(R.id.text_autores);


        //poner cancion
        ponerCancion();

    }

    public void cargarCancion(){
        Picasso.get().load(canciones.get(indiceCancion).getImagen()).into(portada);
        titulo.setText(canciones.get(indiceCancion).getNombre());
        autores.setText(canciones.get(indiceCancion).getAutor());
    }

    public void cambioCancion(){
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }

        ponerCancion();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previous_button:
                if(indiceCancion>0){
                    indiceCancion--;
                    cambioCancion();
                }else{
                    Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.next_button:
                if(indiceCancion<canciones.size()-1){
                    indiceCancion++;
                    cambioCancion();
                }else{
                    Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.play_pause_button:
                cambiarBotonPlay();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
        super.onBackPressed();
    }

    public void cambiarBotonPlay(){
        if(running){
            //acciones
            mPlayer.pause();

            //cambiar boton
            play_pause.setImageResource(R.drawable.play);
            running = false;
        }else{
            //acciones
            mPlayer.start();

            //cambiar boton
            play_pause.setImageResource(R.drawable.pause);
            running = true;
        }
    }

    public void ponerCancion(){
        cargarCancion();

        //audio
        try {
            mPlayer = new MediaPlayer();
            mPlayer.setDataSource(canciones.get(indiceCancion).getAudio());
            mPlayer.prepare();
            mPlayer.start();

            duracion = mPlayer.getDuration();
            progressBar.setMax(duracion);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (mPlayer != null && mPlayer.isPlaying()) {
                        int currentPosition = mPlayer.getCurrentPosition();
                        progressBar.setProgress(currentPosition);
                    }
                }
            }).start();

        }catch (Exception e){
            System.out.println("Error E/S");
        }
    }

}