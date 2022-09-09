package com.example.flowpodcast

import Id
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.flowpodcast.databinding.ActivityPlayerBinding
import com.google.android.youtube.player.*

class PlayerActivity : YouTubeBaseActivity() {

    private val YOUTUBE_API_KEY = "AIzaSyA4RJ1fXn8CUKLYQjjHBWrSAgIUxYZaI98"

    private lateinit var binding: ActivityPlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoSelected = intent.getStringExtra(EXTRA_MESSAGE)
        binding.youtubePlayer.initialize(
            YOUTUBE_API_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubePlayer?,
                    p2: Boolean
                ) {
                    p1?.loadVideo(videoSelected)
                }

                @RequiresApi(Build.VERSION_CODES.M)
                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {
                    Toast.makeText(applicationContext, "Deu RUIM!", Toast.LENGTH_SHORT).show()
                }
            })
    }
}



