package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.CurrentWeatherEntry
import com.resocoder.forecastmvvm.data.ApixuWeatherApiService
import kotlinx.android.synthetic.main.ac_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherViewModel:ViewModel() {


    var currentWeather = MutableLiveData<CurrentWeatherEntry>()

    fun updateWeather() {
        GlobalScope.launch(Dispatchers.Main) {

            val currentWeatherResponse = ApixuWeatherApiService.invoke().getCurrentWeather("Almaty").await()
            currentWeather.value = currentWeatherResponse.currentWeatherEntry
        }

    }
    init {

    }

    override fun onCleared() {

    }

}