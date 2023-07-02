package com.selcannarin.rijksamsterdammuseumapp.data.datasource

import com.selcannarin.rijksamsterdammuseumapp.data.model.artobject.ArtObjectResponse
import com.selcannarin.rijksamsterdammuseumapp.data.remote.MuseumApiService
import com.selcannarin.rijksamsterdammuseumapp.data.remote.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class RemoteMuseumDataSourceImpl @Inject constructor(private val museumApiService: MuseumApiService) :
    RemoteMuseumDataSource, BaseRemoteDataSource() {
    override suspend fun fetchArtObject(): Flow<NetworkResult<ArtObjectResponse>> {
        return getResult {
            museumApiService.fetchArtObject()
        }
    }

}