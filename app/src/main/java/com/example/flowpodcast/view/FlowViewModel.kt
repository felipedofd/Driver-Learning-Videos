package com.example.flowpodcast.view

import JsonBaseResponse
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flowpodcast.remote.RetrofitInitializer
import retrofit2.Call
import retrofit2.Response

class FlowViewModel : ViewModel() {
    val episodes = MutableLiveData<JsonBaseResponse>()
    private val FlowApiService = RetrofitInitializer.flowApiService()

    fun BuscarVideos(): MutableLiveData<JsonBaseResponse> {
        val result = FlowApiService.getVideos(
            key = "AIzaSyA4RJ1fXn8CUKLYQjjHBWrSAgIUxYZaI98",
            channelId = "UC4ncvgh5hFr5O83MH7-jRJg",
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
                Log.d("retrofit cagou", "cagou")
            }
        })
        return episodes
    }
}