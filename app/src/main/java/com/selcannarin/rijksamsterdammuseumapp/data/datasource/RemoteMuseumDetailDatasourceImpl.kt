package com.selcannarin.rijksamsterdammuseumapp.data.datasource

import com.selcannarin.rijksamsterdammuseumapp.data.model.artobjectdetail.ArtObjectDetailResponse
import com.selcannarin.rijksamsterdammuseumapp.data.remote.MuseumApiService
import com.selcannarin.rijksamsterdammuseumapp.data.remote.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class RemoteMuseumDetailDatasourceImpl @Inject constructor(private val museumApiService: MuseumApiService) :
    RemoteMuseumDetailDataSource, BaseRemoteDataSource() {
    override suspend fun fetchArtObjectDetail(getArtobjectNumber: String): Flow<NetworkResult<ArtObjectDetailResponse>> {
        return getResult {
            museumApiService.fetchArtObjectDetail(getArtobjectNumber)
       }
    }

}