package com.selcannarin.rijksamsterdammuseumapp.data.datasource

import com.selcannarin.rijksamsterdammuseumapp.data.model.artobjectdetail.ArtObjectDetailResponse
import com.selcannarin.rijksamsterdammuseumapp.data.remote.NetworkResult
import kotlinx.coroutines.flow.Flow

interface RemoteMuseumDetailDataSource {
    suspend fun fetchArtObjectDetail(getArtobjectNumber: String): Flow<NetworkResult<ArtObjectDetailResponse>>
}