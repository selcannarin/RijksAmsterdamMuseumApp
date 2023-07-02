package com.selcannarin.rijksamsterdammuseumapp.data.model.artobjectdetail


import com.google.gson.annotations.SerializedName

data class ArtObjectDetailResponse(
    @SerializedName("artObject")
    val artObject: ArtObjectX,

    )