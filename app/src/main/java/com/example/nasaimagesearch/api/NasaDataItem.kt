package com.example.nasaimagesearch.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NasaDataItem(
    val center: String,
    val date_created: String?,
    val description: String?,
    val title: String?,
    val media_type: String,
    val nasa_id: String
) : Parcelable
