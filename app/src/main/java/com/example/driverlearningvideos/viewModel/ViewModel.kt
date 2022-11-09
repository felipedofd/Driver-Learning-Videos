package com.example.driverlearningvideos.viewModel

import com.example.driverlearningvideos.data.JsonBaseResponse
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.driverlearningvideos.remote.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class ViewModel : ViewModel() {
    val episodes = MutableLiveData<JsonBaseResponse>()
    private val ApiService = RetrofitInitializer.apiService()

    fun BuscarVideos(): MutableLiveData<JsonBaseResponse> {
        val result = ApiService.getVideos(
            key = "AIzaSyA4RJ1fXn8CUKLYQjjHBWrSAgIUxYZaI98",
            channelId = "UCCNdDo0Nh-y3PcWeUnDGwtg",
            part = "snippet",
            order = "date",
            maxResults = "1000"
        )

        result.enqueue(object : retrofit2.Callback<JsonBaseResponse> {
            override fun onResponse(
                call: Call<JsonBaseResponse>,
                response: Response<JsonBaseResponse>
            ) {
                episodes.postValue(response.body())
            }

            override fun onFailure(call: Call<JsonBaseResponse>, t: Throwable) {
                Log.d("retrofit", "cagou")
            }
        })
        return episodes
    }
}