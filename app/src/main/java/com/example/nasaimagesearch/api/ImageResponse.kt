package com.example.nasaimagesearch.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageResponse(
    val collection: NasaDataCollection
) : Parcelable