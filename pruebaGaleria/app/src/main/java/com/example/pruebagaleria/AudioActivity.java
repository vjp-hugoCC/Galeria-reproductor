package com.example.pruebagaleria;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.pruebagaleria.entidades.Canciones;

public class AudioActivity extends AppCompatActivity implements View.OnClickListener {
    private SeekBar progressBar;
    private ImageView portada;
    private ImageButton play_pause;
    private ImageButton previous;
    private ImageButton next;

    private Boolean running;

    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        //atributos
        running = true;

        //captura
        progressBar = findViewById(R.id.seek_bar);
        portada = findViewById(R.id.portada);
        play_pause = findViewById(R.id.play_pause_button);
        play_pause.setOnClickListener(this);
        previous = findViewById(R.id.previous_button);
        previous.setOnClickListener(this);
        next = findViewById(R.id.next_button);
        next.setOnClickListener(this);


        //audio
        mPlayer = MediaPlayer.create(this, R.raw.cancion1);
        mPlayer.start();

    }

    public void cargarPortada(){
        portada.setImageResource(R.drawable.cancion);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previous_button:
                break;
            case R.id.next_button:
                break;
            case R.id.play_pause_button:
                cambiarBotonPlay();
                break;
        }
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

}