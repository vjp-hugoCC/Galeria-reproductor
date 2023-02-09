package com.example.pruebagaleria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.pruebagaleria.entidades.Canciones;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoActivity extends YouTubeBaseActivity {
    private VideoView video;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private String claveYoutube="AIzaSyA2VcnwHPlV3wbcbneKzH9LyBvE69YSpEg";
    private TextView nomCancion;
    private TextView autor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Canciones cancion= (Canciones) getIntent().getExtras().get("cancion");

        nomCancion=findViewById(R.id.cancionVideo);
        nomCancion.setText(cancion.getNombre());
        autor=findViewById(R.id.autorVideo);
        autor.setText(cancion.getAutor());


        youTubePlayerView=findViewById(R.id.youtube_view);
        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(trimUrl(cancion));

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubePlayerView.initialize(claveYoutube,onInitializedListener);
    }
    public String trimUrl(Canciones cancion) {
        String youtubeUrl = cancion.getVideo();
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(youtubeUrl);

        String videoId = null;
        if (matcher.find()) {
            videoId = matcher.group();
            //System.out.println("Video ID: " + videoId);
        }
        return videoId;
    }
}