package com.selcannarin.rijksamsterdammuseumapp.data.model

import com.google.gson.annotations.SerializedName

data class Facet(

    val facets: List<FacetX>,
    val name: String //principal, type, material, technique

)