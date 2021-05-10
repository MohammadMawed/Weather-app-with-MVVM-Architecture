package com.moohammadmawed.weatherappwithmvvm.api

import com.moohammadmawed.weatherappwithmvvm.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather/Homburg")

    suspend fun getWeather():Response<Weather>

}