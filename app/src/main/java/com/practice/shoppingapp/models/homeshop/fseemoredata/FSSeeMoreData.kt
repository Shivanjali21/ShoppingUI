package com.practice.shoppingapp.models.homeshop.fseemoredata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FSSeeMoreData(
    val fsMoreImg : Int,
    val fsMoreName : String,
    val fsMorePrice : String,
    val fsMoreCode:String,
    val fsMoreSize :String,
    val fsMoreColor:Int
) : Parcelable