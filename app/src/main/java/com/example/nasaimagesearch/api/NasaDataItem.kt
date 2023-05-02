package com.example.nasaimagesearch.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NasaDataItem(
    val title: String,
    val media_type: String,
    val nasa_id: String,
    val data: List<NasaDataObject>
) : Parcelable