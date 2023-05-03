package com.example.nasaimagesearch.data

import android.os.Parcelable
import com.example.nasaimagesearch.api.NasaDataItem
import com.example.nasaimagesearch.api.NasaImageLinks
import kotlinx.android.parcel.Parcelize


@Parcelize
data class NasaImage(
    val href : String,
    val data : List<NasaDataItem>,
    val links : List<NasaImageLinks>
) : Parcelable