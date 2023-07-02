package com.selcannarin.rijksamsterdammuseumapp.data.datasource

import com.selcannarin.rijksamsterdammuseumapp.data.model.artobject.ArtObjectResponse
import com.selcannarin.rijksamsterdammuseumapp.data.remote.NetworkResult
import kotlinx.coroutines.flow.Flow

interface RemoteMuseumDataSource {
    suspend fun fetchArtObject(): Flow<NetworkResult<ArtObjectResponse>>
}