package com.example.nasaimagesearch.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class NasaImage(
    val id: String,
    val description: String?,
    val media_type: String,
    val title: String,
    val date: String,
    val urls: NasaImageUrl,
    val user: NasaImageUser
) : Parcelable {

    @Parcelize
    data class NasaImageUrl(
        val href: String
    ) : Parcelable

    @Parcelize
    data class NasaImageUser(
        val name: String,
        val imageName: String
    ) : Parcelable {
        val attributionUrl get() = "https://images-api.nasa.gov/$imageName?"
    }
}