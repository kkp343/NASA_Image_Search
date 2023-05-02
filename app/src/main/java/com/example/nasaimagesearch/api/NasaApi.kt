package com.example.nasaimagesearch.api

import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {

    companion object{
        const val BASE_URL = "https://images-api.nasa.gov/"
    }

    @GET("search")
    suspend fun searchImages(
        @Query("q") query: String
    ): ImageResponse
}