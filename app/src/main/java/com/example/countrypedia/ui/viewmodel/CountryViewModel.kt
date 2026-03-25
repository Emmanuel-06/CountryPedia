package com.example.countrypedia.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrypedia.data.model.CountryInfo
import com.example.countrypedia.data.model.CountryInfoItem
import com.example.countrypedia.domain.CountryRepository
import com.example.countrypedia.utils.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val countryRepository: CountryRepository
): ViewModel() {
    private val _countryInfo = MutableStateFlow<NetworkResponse<List<CountryInfoItem>>>(NetworkResponse.Loading())
    val countryInfo = _countryInfo.asStateFlow()


    fun getCountryInfo(country: String) {
        _countryInfo.value = NetworkResponse.Loading()
        viewModelScope.launch {
            val countryResponse = countryRepository.getCountryInfo(country)
            _countryInfo.value = countryResponse
        }
    }
}