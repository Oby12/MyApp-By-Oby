package com.learn.myapp_by_oby

import android.os.Parcel
import android.os.Parcelable


data class Budidaya(
    val nameBudidaya: String?,
    val description: String?,
    val image: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nameBudidaya)
        parcel.writeString(description)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Budidaya> {
        override fun createFromParcel(parcel: Parcel): Budidaya {
            return Budidaya(parcel)
        }

        override fun newArray(size: Int): Array<Budidaya?> {
            return arrayOfNulls(size)
        }
    }
}