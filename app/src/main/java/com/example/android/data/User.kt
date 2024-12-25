package com.example.android.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(

    var id : Int,
    var username:String,
    var password:String


) : Parcelable
