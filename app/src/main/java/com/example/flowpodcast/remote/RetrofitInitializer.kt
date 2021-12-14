package com.example.flowpodcast.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/youtube/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun flowApiService() : FlowApiService {
        return retrofit.create(FlowApiService::class.java)
    }

}