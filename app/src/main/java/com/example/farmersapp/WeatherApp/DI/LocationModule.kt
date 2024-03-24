package com.example.farmersapp.WeatherApp.DI

import com.example.farmersapp.WeatherApp.LocationTracking.DefaultLocationTracker
import com.example.farmersapp.WeatherApp.LocationTracking.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {
    @Binds
    @Singleton
    abstract fun bindLocationTracker(defaultLocationTracker: DefaultLocationTracker): LocationTracker
}