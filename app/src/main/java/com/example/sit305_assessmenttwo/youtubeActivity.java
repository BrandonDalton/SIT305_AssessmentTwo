package com.example.sit305_assessmenttwo;

import androidx.appcompat.app.AppCompatActivity;

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
    Button playButton;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtubeactivity);
        //User Interface Init
        playButton = findViewById(R.id.playButton);
        youTubePlayerView = findViewById(R.id.youtubePlayer);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            //When Youtube Launches Successfully Play Video
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("i0hf19Qm_Sc");
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