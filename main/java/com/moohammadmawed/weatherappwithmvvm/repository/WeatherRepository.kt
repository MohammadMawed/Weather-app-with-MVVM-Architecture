package com.moohammadmawed.weatherappwithmvvm.repository

import com.moohammadmawed.weatherappwithmvvm.api.ApiService
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(private val apiService: ApiService){

    suspend fun getWeather()= apiService.getWeather()
}