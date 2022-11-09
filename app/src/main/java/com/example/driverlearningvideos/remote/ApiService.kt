package com.example.driverlearningvideos.remote

import com.example.driverlearningvideos.data.JsonBaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v3/search")
    fun getVideos(
        @Query("key") key: String,
        @Query("channelId") channelId: String,
        @Query("part") part: String,
        @Query("order") order: String,
        @Query("maxResults") maxResults: String
    ): Call<JsonBaseResponse>
}
