package com.selcannarin.rijksamsterdammuseumapp.data.repository

import com.selcannarin.rijksamsterdammuseumapp.data.datasource.RemoteMuseumDetailDataSource
import com.selcannarin.rijksamsterdammuseumapp.data.model.artobjectdetail.ArtObjectDetailResponse
import com.selcannarin.rijksamsterdammuseumapp.data.remote.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MuseumDetailRepositoryImpl  @Inject constructor(private val remoteMuseumDetailDataSource: RemoteMuseumDetailDataSource) :
    MuseumDetailRepository {
    override suspend fun fetchArtObjectDetail(getArtobjectNumber: String): Flow<NetworkResult<ArtObjectDetailResponse>> =
        remoteMuseumDetailDataSource.fetchArtObjectDetail(getArtobjectNumber)

}