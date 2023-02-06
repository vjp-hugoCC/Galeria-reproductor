package com.example.pruebagaleria;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.SeekBar;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class AudioActivity extends AppCompatActivity {
    private SeekBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        //captura
        progressBar = findViewById(R.id.seek_bar);

        //audio
        // Inicializar ExoPlayer
        SimpleExoPlayer player = new SimpleExoPlayer.Builder(this).build();

        // Crear una fuente de medios a partir de una URL
        Uri audioUri = Uri.parse("https://www.youtube.com/watch?v=video_id");
        MediaSource mediaSource = new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory("exoplayer-codelab")).createMediaSource(audioUri);

        // Preparar la fuente de medios en el reproductor
        player.prepare(mediaSource);

        // Iniciar la reproducción
        player.setPlayWhenReady(true);
    }
}