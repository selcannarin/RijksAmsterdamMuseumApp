package com.selcannarin.rijksamsterdammuseumapp.data.remote

import com.selcannarin.rijksamsterdammuseumapp.data.model.ArtObjectResponse
import com.selcannarin.rijksamsterdammuseumapp.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MuseumApiService {

    @GET("en/collection?imgonly=true&ps=50")
    suspend fun fetchArtObject(
        @Query("key") api_key: String = API_KEY
    ): Response<ArtObjectResponse>
}