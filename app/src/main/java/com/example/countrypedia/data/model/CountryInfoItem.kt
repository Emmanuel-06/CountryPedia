package com.example.countrypedia.data.model

data class CountryInfoItem(
    val capital: List<String>,
    val continents: List<String>,
    val currencies: Currencies,
    val demonyms: Demonyms,
    val flags: Flags,
    val languages: Languages,
    val name: Name,
    val population: Int,
    val region: String,
    val subregion: String,
    val timezones: List<String>,
)