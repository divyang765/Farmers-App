package com.example.farmersapp.WeatherApp.Data

import com.example.farmersapp.WeatherApp.Domain.WeatherType
import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType

)
