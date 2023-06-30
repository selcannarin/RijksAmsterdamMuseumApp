package com.selcannarin.rijksamsterdammuseumapp.data.model

import com.google.gson.annotations.SerializedName

data class ArtObject(

    val hasImage: Boolean,
    val id: String,
    val longTitle: String,
    val objectNumber: String,
    val permitDownload: Boolean,
    val principalOrFirstMaker: String,
    val productionPlaces: List<String>,
    val showImage: Boolean,
    val title: String,
    val webImage: WebImage
)

