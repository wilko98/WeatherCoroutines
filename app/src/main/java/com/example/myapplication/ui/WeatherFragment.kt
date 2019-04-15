package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.resocoder.forecastmvvm.data.ApixuWeatherApiService
import kotlinx.android.synthetic.main.activity_main.*



class WeatherFragment: Fragment(){

    var apiServise: Any? = null

    companion object{
        fun newInstance():WeatherFragment{
            val fragment = WeatherFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v:View = inflater.inflate(R.layout.weather_fragment,container,false)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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