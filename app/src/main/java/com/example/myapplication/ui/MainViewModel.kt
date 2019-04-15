package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.CurrentWeatherEntry
import com.resocoder.forecastmvvm.data.ApixuWeatherApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    var temp = MutableLiveData<String>()
    var windDegree = MutableLiveData<String>()
    var windSpeed = MutableLiveData<String>()
    var pressure = MutableLiveData<String>()
    var currentWeather = MutableLiveData<CurrentWeatherEntry>()

    fun updateWeather() {
        GlobalScope.launch(Dispatchers.Main) {

            val currentWeatherResponse = ApixuWeatherApiService.invoke().getCurrentWeather("Almaty").await()
            currentWeather.value = currentWeatherResponse.currentWeatherEntry
            temp.value =
                currentWeatherResponse.currentWeatherEntry.tempC.toString() +"°C"
            windDegree.value =
                "WindDegree: " + currentWeatherResponse.currentWeatherEntry.windDegree.toString() + '°'
            windSpeed.value =
                "WindSpeed: " + currentWeatherResponse.currentWeatherEntry.windKph.toString() + "km/h"
            pressure.value =
                "Pressure: " + currentWeatherResponse.currentWeatherEntry.pressureMb
        }

    }
    init {

    }

    override fun onCleared() {

    }

}