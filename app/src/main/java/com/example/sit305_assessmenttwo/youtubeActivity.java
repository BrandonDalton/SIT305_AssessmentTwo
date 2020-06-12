package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class youtubeActivity extends YouTubeBaseActivity {
    //Variable Init
    YouTubePlayerView youTubePlayerView;
    Button playButton, buttonBack;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtubeactivity);
        //User Interface Init
        playButton = findViewById(R.id.playButton);
        buttonBack = findViewById(R.id.backButton);
        youTubePlayerView = findViewById(R.id.youtubePlayer);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(youtubeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            //When Youtube Launches Successfully Play Video
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("72BSpakRgyc");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        //Play Button Is Pressed
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Will Init Youtube Player with our API Key
                youTubePlayerView.initialize(youtubeConfig.getApiKey(), onInitializedListener);
            }
        });
    }
}