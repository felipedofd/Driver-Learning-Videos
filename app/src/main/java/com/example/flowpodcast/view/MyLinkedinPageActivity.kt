package com.example.flowpodcast.view

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.flowpodcast.databinding.ActivityMyLinkedinPageBinding
import com.example.flowpodcast.databinding.ActivityWebViewBinding

class MyLinkedinPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyLinkedinPageBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyLinkedinPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = "https://www.linkedin.com/in/felipe-anzolin-5b4633101/"
        binding.webView.loadUrl(url)
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.domStorageEnabled = true
    }
}
