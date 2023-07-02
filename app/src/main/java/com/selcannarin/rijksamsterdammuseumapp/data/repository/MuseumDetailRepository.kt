package com.selcannarin.rijksamsterdammuseumapp.data.repository

import com.selcannarin.rijksamsterdammuseumapp.data.model.artobjectdetail.ArtObjectDetailResponse
import com.selcannarin.rijksamsterdammuseumapp.data.remote.NetworkResult
import kotlinx.coroutines.flow.Flow

interface MuseumDetailRepository {
    suspend fun fetchArtObjectDetail(getArtobjectNumber: String): Flow<NetworkResult<ArtObjectDetailResponse>>
}