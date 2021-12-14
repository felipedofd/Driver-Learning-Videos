package com.example.flowpodcast.remote

import Items
import JsonBaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlowApiService {

    @GET("v3/search")
    fun getVideos(
        @Query("key") key: String,
        @Query("channelId") channelId: String,
        @Query("part") part: String,
        @Query("order") order: String,
        @Query("maxResults") maxResults: String
    ): Call<JsonBaseResponse>
}
