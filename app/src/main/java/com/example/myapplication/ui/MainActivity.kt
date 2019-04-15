package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.resocoder.forecastmvvm.data.ApixuWeatherApiService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var apiServise: Any? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.currentWeather.observe(this, Observer { cw->
            run {
                temperature.text = cw.tempC.toString()
                refresher.isRefreshing = false
            }
        })


        apiServise = ApixuWeatherApiService()
        refresher.setOnRefreshListener { viewModel.updateWeather() }
    }

}
