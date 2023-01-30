package com.example.pruebagaleria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.pruebagaleria.entidades.Canciones;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity {
    private VideoView video;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private String claveYoutube="AIzaSyA2VcnwHPlV3wbcbneKzH9LyBvE69YSpEg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Canciones cancion= (Canciones) getIntent().getExtras().get("cancion");


        youTubePlayerView=findViewById(R.id.youtube_view);
        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("w9xfXsqIGKk");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubePlayerView.initialize(claveYoutube,onInitializedListener);
    }


}