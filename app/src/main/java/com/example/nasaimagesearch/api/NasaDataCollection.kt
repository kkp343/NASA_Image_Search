package com.example.nasaimagesearch.api

import android.os.Parcelable
import com.example.nasaimagesearch.data.NasaImage
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NasaDataCollection(
    val href: String,
    val items: List<NasaImage>
    ) : Parcelable