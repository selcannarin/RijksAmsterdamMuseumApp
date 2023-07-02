package com.selcannarin.rijksamsterdammuseumapp.data.repository

import com.selcannarin.rijksamsterdammuseumapp.data.model.artobject.ArtObjectResponse
import com.selcannarin.rijksamsterdammuseumapp.data.remote.NetworkResult
import kotlinx.coroutines.flow.Flow

interface MuseumRepository {
    suspend fun fetchArtObject(): Flow<NetworkResult<ArtObjectResponse>>
}