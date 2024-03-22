package com.example.farmersapp.WeatherApp.Data

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>
    // int here is day day 0 is today and api returns data for 7 days
    ,
    val currentWeatherData: WeatherData?
    // data for weather at current hour of api call

)
