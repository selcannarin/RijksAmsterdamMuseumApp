package com.selcannarin.rijksamsterdammuseumapp.data.model

data class MuseumViewState(
    val isLoading: Boolean = true,
    val artObjectList: ArtObjectResponse? = null,
    val error: String = ""
)