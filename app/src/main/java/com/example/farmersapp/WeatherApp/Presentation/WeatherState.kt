package com.example.farmersapp.WeatherApp.Presentation

import com.example.farmersapp.WeatherApp.Data.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
