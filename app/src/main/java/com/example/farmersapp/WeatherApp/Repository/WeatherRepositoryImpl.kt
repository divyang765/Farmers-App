package com.example.farmersapp.WeatherApp.Repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.farmersapp.WeatherApp.Data.WeatherInfo
import com.example.farmersapp.WeatherApp.Domain.Mappers.toWeatherInfo
import com.example.farmersapp.WeatherApp.Domain.Resource
import com.example.farmersapp.WeatherApp.Domain.WeatherApi
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(lat = lat, long = long).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "an unknown error occured")
        }
    }


}