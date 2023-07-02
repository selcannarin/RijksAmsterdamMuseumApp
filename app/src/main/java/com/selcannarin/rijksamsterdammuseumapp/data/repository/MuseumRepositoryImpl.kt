package com.selcannarin.rijksamsterdammuseumapp.data.repository

import com.selcannarin.rijksamsterdammuseumapp.data.datasource.RemoteMuseumDataSource
import com.selcannarin.rijksamsterdammuseumapp.data.model.artobject.ArtObjectResponse
import com.selcannarin.rijksamsterdammuseumapp.data.remote.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MuseumRepositoryImpl  @Inject constructor(private val remoteMuseumDataSource: RemoteMuseumDataSource) :
    MuseumRepository {
    override suspend fun fetchArtObject(): Flow<NetworkResult<ArtObjectResponse>> =
        remoteMuseumDataSource.fetchArtObject()
}