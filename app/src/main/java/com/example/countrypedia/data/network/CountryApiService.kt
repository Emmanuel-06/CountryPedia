package com.example.countrypedia.data.network

import com.example.countrypedia.data.model.CountryInfoItem
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface CountryApiService {
    @GET("v3.1/name/{country}")
    suspend fun getCountryInfo(
        @Path ("country") country: String
    ): List<CountryInfoItem>
}