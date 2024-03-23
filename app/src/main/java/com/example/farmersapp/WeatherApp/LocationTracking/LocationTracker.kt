package com.example.farmersapp.WeatherApp.LocationTracking

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}