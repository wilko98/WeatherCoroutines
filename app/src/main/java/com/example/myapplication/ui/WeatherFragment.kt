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
import kotlinx.android.synthetic.main.fr_weather.*


class WeatherFragment: Fragment(){

    var apiServise: Any? = null

    companion object{
        fun newInstance():WeatherFragment{
            val fragment = WeatherFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v:View = inflater.inflate(R.layout.fr_weather,container,false)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        viewModel.currentWeather.observe(this, Observer { cw->
            run {
                temperature.text = cw.tempC.toString()
                windDegree.text = cw.windDegree.toString()
                windSpeed.text = cw.windKph.toString()
                pressure.text = cw.pressureMb.toString()
                refresher.isRefreshing = false
            }
        })


        apiServise = ApixuWeatherApiService()
        refresher.setOnRefreshListener { viewModel.updateWeather() }
    }

}