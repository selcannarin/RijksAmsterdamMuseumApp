package com.selcannarin.rijksamsterdammuseumapp.data.model.viewstate

import com.selcannarin.rijksamsterdammuseumapp.data.model.artobjectdetail.ArtObjectDetailResponse

data class MuseumDetailViewState(
    val isLoading: Boolean = true,
    val artObjectDetail: ArtObjectDetailResponse? = null,
    val error: String = ""
)