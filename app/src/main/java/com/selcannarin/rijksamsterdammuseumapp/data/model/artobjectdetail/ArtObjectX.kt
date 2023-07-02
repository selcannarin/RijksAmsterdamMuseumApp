package com.selcannarin.rijksamsterdammuseumapp.data.model.artobjectdetail


import com.google.gson.annotations.SerializedName
import com.selcannarin.rijksamsterdammuseumapp.data.model.artobject.WebImage

data class ArtObjectX(

    @SerializedName("id")
    val id: String,
    @SerializedName("dating")
    val dating: Dating,
    @SerializedName("longTitle")
    val longTitle: String,
    @SerializedName("materials")
    val materials: List<String>,
    @SerializedName("objectCollection")
    val objectCollection: List<String>,
    @SerializedName("objectNumber")
    val objectNumber: String,
    @SerializedName("objectTypes")
    val objectTypes: List<String>,
    @SerializedName("principalMaker")
    val principalMaker: String,
    @SerializedName("productionPlaces")
    val productionPlaces: List<String>,
    @SerializedName("techniques")
    val techniques: List<Any>,
    @SerializedName("title")
    val title: String,
    @SerializedName("webImage")
    val webImage: WebImage

)