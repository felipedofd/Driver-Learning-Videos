package com.example.flowpodcast

import Id
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.flowpodcast.databinding.ActivityPlayerBinding
import com.google.android.youtube.player.*

class PlayerActivity : YouTubeBaseActivity() {

    var VIDEOS_ID = "nz7EQnjWhhM"
    val YOUTUBE_API_KEY = "AIzaSyA4RJ1fXn8CUKLYQjjHBWrSAgIUxYZaI98"

    private lateinit var binding: ActivityPlayerBinding
    private lateinit var youtubePlayer: YouTubePlayerView
    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val videoSelected = intent.getStringExtra(EXTRA_MESSAGE)
        VIDEOS_ID = EXTRA_MESSAGE



        youtubePlayer = findViewById(R.id.youtube_player)
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(VIDEOS_ID)
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext, "Deu RUIM!", Toast.LENGTH_SHORT).show()
            }
        }
        youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
    }
}



