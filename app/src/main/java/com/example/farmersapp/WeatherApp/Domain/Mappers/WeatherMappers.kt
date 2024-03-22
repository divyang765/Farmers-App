package com.example.farmersapp.WeatherApp.Domain.Mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.farmersapp.WeatherApp.Data.WeatherData
import com.example.farmersapp.WeatherApp.Data.WeatherInfo
import com.example.farmersapp.WeatherApp.Domain.WeatherDataDto
import com.example.farmersapp.WeatherApp.Domain.WeatherDto
import com.example.farmersapp.WeatherApp.Domain.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class indexedWeatherData(
    val index: Int,
    val data: WeatherData
)

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    // mapping time values to weather details objects
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]

        indexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)

            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }

}
// function to map weatherdatadto to map and will return a map


@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}