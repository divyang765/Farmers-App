package com.example.farmersapp.WeatherApp.Repository

import com.example.farmersapp.WeatherApp.Data.WeatherInfo
import com.example.farmersapp.WeatherApp.Domain.Resource

interface WeatherRepository {

    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}