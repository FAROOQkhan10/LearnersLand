package com.farooqkhan.learnersland;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public class Video extends AppCompatActivity {
//    FirebaseFirestore database = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
//        final String catId = getIntent().getStringExtra("catId");
         String url = getIntent().getStringExtra("url");
//        Uri uri = Uri.parse(url);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
           @Override
           public void onReady(YouTubePlayer youTubePlayer) {
               String uri = "cA7wS7wyDLA";

//               youTubePlayer.loadVideo(String.valueOf(url),0);
               youTubePlayer.loadVideo(uri,0);

           }
       });

    }
}