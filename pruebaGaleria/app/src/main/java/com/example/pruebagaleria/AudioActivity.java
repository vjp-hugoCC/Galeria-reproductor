package com.example.pruebagaleria;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.pruebagaleria.entidades.Canciones;

public class AudioActivity extends AppCompatActivity {
    private SeekBar progressBar;
    private ImageView portada;

    MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        //captura
        progressBar = findViewById(R.id.seek_bar);
        portada = findViewById(R.id.portada);

        /*//audio
        mPlayer = MediaPlayer.create(this, R.raw.cancion1);
        mPlayer.start();
        */
    }

    public void cargarPortada(){
        portada.setImageResource(R.drawable.cancion);
    }


}