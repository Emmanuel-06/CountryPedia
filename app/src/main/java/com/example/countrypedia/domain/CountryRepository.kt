package com.example.countrypedia.domain

import android.util.Log
import com.example.countrypedia.data.model.CountryInfoItem
import com.example.countrypedia.data.network.CountryApiService
import com.example.countrypedia.utils.NetworkResponse
import javax.inject.Inject

class CountryRepository @Inject constructor(
    val countryApi: CountryApiService
) {
    suspend fun getCountryInfo(country: String): NetworkResponse<List<CountryInfoItem>>{
        return try {
            val response = countryApi.getCountryInfo(country)
            NetworkResponse.Success(response)

        } catch (e: Exception){
            Log.d("ERROR", "${e.message}")
            NetworkResponse.Error("An error occured: ${e.message}")
        }
    }

}