package com.example.nasaimagesearch.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NasaImageLinks(
    val href : String?,
    val rel : String?
) : Parcelable
