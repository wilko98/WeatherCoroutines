package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.resocoder.forecastmvvm.data.ApixuWeatherApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),MainView {

    var apiServise: Any? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiServise = ApixuWeatherApiService()
        refresher.setOnRefreshListener { updateWeather() }
    }



    override fun updateWeather() {
        GlobalScope.launch(Dispatchers.Main) {
            val currentWeatherResponse = (apiServise as ApixuWeatherApiService).getCurrentWeather("Almaty").await()
            temperature.text =
                "Temperature: ${currentWeatherResponse.currentWeatherEntry.tempC.toString()} °C"
            windDegree.text =
                "WindDegree: " + currentWeatherResponse.currentWeatherEntry.windDegree.toString() + '°'
            windSpeed.text =
                "WindSpeed: " + currentWeatherResponse.currentWeatherEntry.windKph.toString() + "km/h"
            pressure.text =
                "Pressure: " + currentWeatherResponse.currentWeatherEntry.pressureMb
            refresher.isRefreshing = false
        }
    }

}
