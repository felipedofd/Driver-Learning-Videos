package com.example.driverlearningvideos


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.driverlearningvideos.controller.ListEpisodesAdapter
import com.example.driverlearningvideos.databinding.ActivityMainBinding
import com.example.driverlearningvideos.player.PlayerActivity
import com.example.driverlearningvideos.view.MyLinkedinPageActivity
import com.example.driverlearningvideos.viewModel.ViewModel
import com.example.driverlearningvideos.view.WebViewActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

const val EXTRA_MESSAGE = "youTubePlayer"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mViewModel: ViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.logo.setOnClickListener {
//            val intent = Intent(this, PlayerActivity::class.java)
//            intent.putExtra("youTubePlayer", false)
//            startActivity(intent)
//        }

        binding.webView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("webiew", false)
            startActivity(intent)
        }

        binding.myLinkedinPage.setOnClickListener {
            val intent = Intent(this, MyLinkedinPageActivity::class.java)
            intent.putExtra("my_linkedin_perfil", false)
            startActivity(intent)
        }

        mViewModel.BuscarVideos()
        mViewModel.episodes.observe(this) {
            binding.episodesList.adapter = ListEpisodesAdapter(
                it.items, this
            )
        }

    }

}



