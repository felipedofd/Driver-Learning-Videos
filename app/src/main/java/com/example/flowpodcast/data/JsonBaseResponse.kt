package com.example.flowpodcast.data

data class JsonBaseResponse(

    val kind: String,
    val etag: String,
    val nextPageToken: String,
    val regionCode: String,
    val pageInfo: PageInfo,
    val items: List<Items>
)