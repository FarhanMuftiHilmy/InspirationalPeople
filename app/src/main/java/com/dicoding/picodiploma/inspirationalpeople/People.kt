package com.dicoding.picodiploma.inspirationalpeople

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class People(
    var name: String = "",
    var detail: String = "",
    var photo: Int = 0,
    var quote: String = "",
    var info: String = ""
): Parcelable