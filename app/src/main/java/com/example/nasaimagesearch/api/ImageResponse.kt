package com.example.nasaimagesearch.api

import com.example.nasaimagesearch.data.NasaImage

data class ImageResponse(
    val items: List<NasaImage>
)