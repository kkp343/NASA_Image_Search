package com.example.nasaimagesearch.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NasaDataObject(
    val center: String,
    val date_created: String,
    val description: String,
    val keywords: String
) : Parcelable
