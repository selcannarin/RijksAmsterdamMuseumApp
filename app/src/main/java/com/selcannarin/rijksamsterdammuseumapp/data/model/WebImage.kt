package com.selcannarin.rijksamsterdammuseumapp.data.model

import com.google.gson.annotations.SerializedName

data class WebImage(

    val guid: String,
    val height: Int,
    val offsetPercentageX: Int,
    val offsetPercentageY: Int,
    val url: String,
    val width: Int
)