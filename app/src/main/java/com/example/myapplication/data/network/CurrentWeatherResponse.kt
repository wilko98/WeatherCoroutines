package com.example.myapplication.data.network

import com.example.myapplication.data.model.CurrentWeatherEntry
import com.example.myapplication.data.model.Location
import com.google.gson.annotations.SerializedName

data class  CurrentWeatherResponse(
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)