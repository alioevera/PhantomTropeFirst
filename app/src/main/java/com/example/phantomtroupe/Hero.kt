package com.example.phantomtroupe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    var name: String,
    var description: String,
    var photo: Int,
    var number: Int,
    var birthDate: String
) : Parcelable
