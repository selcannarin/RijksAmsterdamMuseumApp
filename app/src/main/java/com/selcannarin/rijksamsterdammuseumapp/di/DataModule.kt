package com.selcannarin.rijksamsterdammuseumapp.di

import com.selcannarin.rijksamsterdammuseumapp.data.datasource.RemoteMuseumDataSource
import com.selcannarin.rijksamsterdammuseumapp.data.datasource.RemoteMuseumDataSourceImpl
import com.selcannarin.rijksamsterdammuseumapp.data.remote.MuseumApiService
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
}