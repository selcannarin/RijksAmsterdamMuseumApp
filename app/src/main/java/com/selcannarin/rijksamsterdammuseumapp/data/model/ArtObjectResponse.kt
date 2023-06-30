package com.selcannarin.rijksamsterdammuseumapp.data.model

import com.google.gson.annotations.SerializedName

data class ArtObjectResponse(

    @SerializedName("artObjects")
    val artObjects: List<ArtObject>,

    @SerializedName("facets")
    val facets: List<Facet>

)