package com.moohammadmawed.weatherappwithmvvm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.moohammadmawed.weatherappwithmvvm.databinding.ActivityMainBinding
import com.moohammadmawed.weatherappwithmvvm.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel.weatherResp.observe(this, { Weather ->
            binding.apply {
                tvCity.text = "Homburg"
                tvTemp.text = Weather.temperature

                when (Weather.description) {
                    "Clear" -> {
                        imageViewState.setImageResource(R.drawable.clear)
                    }
                    "Cloudy" -> {
                        imageViewState.setImageResource(R.drawable.clouds)
                    }
                    "Rain" -> {
                        imageViewState.setImageResource(R.drawable.rain)
                    }
                    "Snow" -> {
                        imageViewState.setImageResource(R.drawable.snow)
                    }
                }

                tvDescription . text = Weather . description
                tvWindSpeed.text = Weather.wind

                val forecast1 = Weather.forecast[0]
                val forecast2 = Weather.forecast[1]
                val forecast3 = Weather.forecast[2]

                tvForecast1.text = forecast1.temperature
                tvForecast2.text = forecast2.temperature
                tvForecast3.text = forecast3.temperature

                val calendar = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
                var nextDay = calendar + 1
                if (nextDay == 8) {
                    nextDay = 1
                }
                when (nextDay) {
                    1 -> tvForecastDay1.text = "Sunday"
                    2 -> tvForecastDay1.text = "Monday"
                    3 -> tvForecastDay1.text = "Tuesday"
                    4 -> tvForecastDay1.text = "Wednesday"
                    5 -> tvForecastDay1.text = "Thursday"
                    6 -> tvForecastDay1.text = "Friday"
                    7 -> tvForecastDay1.text = "Saturday"
                }
                var nextDay2 = nextDay + 1
                if (nextDay2 == 8) {
                    nextDay2 = 1
                }
                when (nextDay2) {
                    1 -> tvForecastDay2.text = "Sunday"
                    2 -> tvForecastDay2.text = "Monday"
                    3 -> tvForecastDay2.text = "Tuesday"
                    4 -> tvForecastDay2.text = "Wednesday"
                    5 -> tvForecastDay2.text = "Thursday"
                    6 -> tvForecastDay2.text = "Friday"
                    7 -> tvForecastDay2.text = "Saturday"
                }
                var nextDay3 = nextDay2 + 1
                if (nextDay3 == 8) {
                    nextDay3 = 1
                }
                when (nextDay3) {
                    1 -> tvForecastDay3.text = "Sunday"
                    2 -> tvForecastDay3.text = "Monday"
                    3 -> tvForecastDay3.text = "Tuesday"
                    4 -> tvForecastDay3.text = "Wednesday"
                    5 -> tvForecastDay3.text = "Thursday"
                    6 -> tvForecastDay3.text = "Friday"
                    7 -> tvForecastDay3.text = "Saturday"
                }
            }
        })
    }
}