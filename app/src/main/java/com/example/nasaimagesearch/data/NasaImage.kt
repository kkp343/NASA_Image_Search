package com.example.nasaimagesearch.data

import android.os.Parcelable
import com.example.nasaimagesearch.api.NasaDataItem
import kotlinx.android.parcel.Parcelize


@Parcelize
data class NasaImage(
    val dataPhoto : NasaDataItem
) : Parcelable

//{
//
//    @Parcelize
//    data class NasaImageUrl(
//        val href: String
//    ) : Parcelable
//
//    @Parcelize
//    data class NasaImageUser(
//        val name: String,
//        val imageName: String
//    ) : Parcelable {
//        val attributionUrl get() = "https://images-api.nasa.gov/$imageName?"
//    }
//}