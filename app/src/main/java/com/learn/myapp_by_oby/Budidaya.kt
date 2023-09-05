package com.learn.myapp_by_oby

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Budidaya(
    val nameBudidaya: String,
    val description: String,
    val perawatan: String,
    val jenis: String,
    val habitat : String,
    val namaLatin : String,
    val image: Int
) : Parcelable