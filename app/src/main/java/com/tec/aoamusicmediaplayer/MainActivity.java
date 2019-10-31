package com.tec.aoamusicmediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents(){
        ImageButton playImageButton     = findViewById(R.id.playMainImageButton);
        ImageButton pauseImageButton    = findViewById(R.id.pauseMainImageButton);
        ImageButton continueImageButton = findViewById(R.id.continueMainImageButton);
        ImageButton stopImageButton     = findViewById(R.id.stopMainImageButton);
        ImageButton loopImageButton     = findViewById(R.id.loopMainImageButton);

        position = 0;

        playImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.song);
            mediaPlayer.start();
            Toast.makeText(getApplicationContext(),"La cancion se empesara a reproducir",Toast.LENGTH_LONG).show();

            }
        });

        pauseImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer != null && mediaPlayer.isPlaying()){
                    position    = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                    Toast.makeText(getApplicationContext(),"La cancion se pauso",Toast.LENGTH_LONG).show();
                }


            }
        });

        continueImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null ){
                    mediaPlayer.seekTo(position);
                    mediaPlayer.start();
                    Toast.makeText(getApplicationContext(),"La cancion continuara",Toast.LENGTH_LONG).show();
                }

            }
        });

        stopImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer != null && mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    position = 0;
                    Toast.makeText(getApplicationContext(),"La cancion se detuvo",Toast.LENGTH_LONG).show();
                }


            }
        });

        loopImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isLooping()){
                    mediaPlayer.setLooping(false);
                    Toast.makeText(getApplicationContext(),"La cancion dejara de repetirse",Toast.LENGTH_LONG).show();
                }else {
                    mediaPlayer.setLooping(true);
                    Toast.makeText(getApplicationContext(),"La cancion se repetira",Toast.LENGTH_LONG).show();
                }


            }
        });
    }


}
