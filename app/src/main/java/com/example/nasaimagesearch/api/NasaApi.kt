package com.example.nasaimagesearch.api

import com.example.nasaimagesearch.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NasaApi {

    companion object{
        const val BASE_URL = "https://images-api.nasa.gov/"
        const val CLIENT_ID = BuildConfig.SERVER_URL
    }

//    @Headers("Access-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search")
    suspend fun searchImages(
        @Query("q") query: String
//        @Query("page") page: Int,
//        @Query("page_size") page_size: Int
//        @Query("description") description: String,
//        @Query("media_type") media_type: String
    ): ImageResponse
}