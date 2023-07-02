package com.selcannarin.rijksamsterdammuseumapp.data.model.artobject

import com.google.gson.annotations.SerializedName

data class ArtObjectResponse(

    @SerializedName("artObjects")
    val artObjects: List<ArtObject>

)