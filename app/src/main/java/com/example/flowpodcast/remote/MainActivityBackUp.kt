//package com.example.flowpodcast.remote
//
//import android.os.Bundle
//import android.widget.ImageButton
//import android.widget.Toast
//import androidx.lifecycle.ViewModelProvider
//import com.example.flowpodcast.controller.ListEpisodesAdapter
//import com.example.flowpodcast.databinding.FragmetMainBinding
//import com.example.flowpodcast.view.FlowViewModel
//import com.google.android.youtube.player.YouTubeBaseActivity
//import com.google.android.youtube.player.YouTubeInitializationResult
//import com.google.android.youtube.player.YouTubePlayer
//import com.google.android.youtube.player.YouTubePlayerView
//
//class MainActivityBackUp : YouTubeBaseActivity() {
//
//    val VIDEOS_ID = "nz7EQnjWhhM"
//    val YOUTUBE_API_KEY = "AIzaSyA4RJ1fXn8CUKLYQjjHBWrSAgIUxYZaI98"
//
//    private val mViewModel : FlowViewModel by view
//
//    private lateinit var binding :FragmetMainBinding
//
//    private lateinit var youtubePlayer: YouTubePlayerView
//    private lateinit var btnPlay : ImageButton
//
//    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = FragmetMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        flowViewModel =ViewModelProvider(this)[FlowViewModel::class.java]
//        flowViewModel.BuscarVideos()
//        flowViewModel.episodes.observe(this){
//            binding.episodesList.adapter = ListEpisodesAdapter(it, this)
//        }
//
//
//
//
//        youtubePlayer = findViewById(R.id.youtube_player)
//
//        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener{
//            override fun onInitializationSuccess(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubePlayer?,
//                p2: Boolean
//            ) {
//                p1?.loadVideo(VIDEOS_ID)
//            }
//            override fun onInitializationFailure(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubeInitializationResult?
//            ) {
//                Toast.makeText(applicationContext, "Deu RUIM!", Toast.LENGTH_SHORT).show()
//            }
//        }
//        youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
//    }
//
//
//
//
//
//
//}