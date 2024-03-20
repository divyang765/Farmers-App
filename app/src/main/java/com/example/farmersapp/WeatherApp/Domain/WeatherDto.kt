package com.example.farmersapp.WeatherApp.Domain

import com.squareup.moshi.Json

data class WeatherDto(

    @field:Json(name = "hourly")
    val weatherData: WeatherDataDto
)
// we will refer json object as weatherData