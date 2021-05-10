package com.moohammadmawed.weatherappwithmvvm.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moohammadmawed.weatherappwithmvvm.api.ApiService
import com.moohammadmawed.weatherappwithmvvm.model.Weather
import com.moohammadmawed.weatherappwithmvvm.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject
constructor(private val repository: WeatherRepository) : ViewModel() {

    private val resp = MutableLiveData<Weather>()
    val weatherResp: LiveData<Weather>
        get() = resp

    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        repository.getWeather().let { response ->
            if (response.isSuccessful) {
                resp.postValue(response.body())
            } else {
                Log.d("TAG", "getWeather Error Response: ${response.message()}")
            }
        }
    }
}
