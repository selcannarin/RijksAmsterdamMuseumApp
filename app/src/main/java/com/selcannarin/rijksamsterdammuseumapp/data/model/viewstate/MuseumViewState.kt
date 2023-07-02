package com.selcannarin.rijksamsterdammuseumapp.data.model.viewstate

import com.selcannarin.rijksamsterdammuseumapp.data.model.artobject.ArtObjectResponse

data class MuseumViewState(
    val isLoading: Boolean = true,
    val artObjectList: ArtObjectResponse? = null,
    val error: String = ""
)