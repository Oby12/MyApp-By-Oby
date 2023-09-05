package com.learn.myapp_by_oby

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AboutBobby(
    val nama : String,
    val email : String,
    val potodiri : Int
) : Parcelable
