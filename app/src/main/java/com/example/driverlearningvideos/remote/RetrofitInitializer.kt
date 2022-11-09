package com.example.driverlearningvideos.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/youtube/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun apiService() : ApiService {
        return retrofit.create(ApiService::class.java)
    }

}