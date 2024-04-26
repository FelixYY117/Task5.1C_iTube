package com.example.iTube;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;


import androidx.annotation.NonNull;



public class PlayVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        // 获取对 YouTubePlayerView 的引用
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);


        getLifecycle().addObserver(youTubePlayerView);

        // 设置 YouTubePlayerView 的监听器，在视频准备就绪时自动开始播放视频

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                // 指定要播放的 YouTube 视频的视频ID
                String videoId = "S0Q4gqBUs7c"; // 替换为你想要播放的 YouTube 视频的视频ID
                // 加载并播放视频
                youTubePlayer.loadVideo(videoId, 0); // 0 代表从视频的起始位置开始播放
            }
        });
    }
}
