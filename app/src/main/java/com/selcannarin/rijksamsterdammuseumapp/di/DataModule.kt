package com.selcannarin.rijksamsterdammuseumapp.di

import com.selcannarin.rijksamsterdammuseumapp.data.datasource.RemoteMuseumDataSource
import com.selcannarin.rijksamsterdammuseumapp.data.datasource.RemoteMuseumDataSourceImpl
import com.selcannarin.rijksamsterdammuseumapp.data.datasource.RemoteMuseumDetailDataSource
import com.selcannarin.rijksamsterdammuseumapp.data.datasource.RemoteMuseumDetailDatasourceImpl
import com.selcannarin.rijksamsterdammuseumapp.data.remote.MuseumApiService
import com.selcannarin.rijksamsterdammuseumapp.data.repository.MuseumDetailRepository
import com.selcannarin.rijksamsterdammuseumapp.data.repository.MuseumDetailRepositoryImpl
import com.selcannarin.rijksamsterdammuseumapp.data.repository.MuseumRepository
import com.selcannarin.rijksamsterdammuseumapp.data.repository.MuseumRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun providesApiRemoteDataSource(museumApiService: MuseumApiService): RemoteMuseumDataSource {
        return RemoteMuseumDataSourceImpl(museumApiService)
    }

    @Provides
    fun providesApiRemoteRepository(remoteMuseumDataSource: RemoteMuseumDataSource): MuseumRepository {
        return MuseumRepositoryImpl(remoteMuseumDataSource)
    }

    @Provides
    fun providesDetailApiDataSource(museumApiService: MuseumApiService): RemoteMuseumDetailDataSource {
        return RemoteMuseumDetailDatasourceImpl(museumApiService)
    }

    @Provides
    fun providesDetailApiRepository(remoteMuseumDetailDataSource: RemoteMuseumDetailDataSource): MuseumDetailRepository {
        return MuseumDetailRepositoryImpl(remoteMuseumDetailDataSource)
    }
}