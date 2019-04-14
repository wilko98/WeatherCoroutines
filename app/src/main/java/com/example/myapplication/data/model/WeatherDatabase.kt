package com.example.myapplication.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1
)
abstract class WeatherDatabase: RoomDatabase(){

    abstract fun currentWetherDao():CurrentWeatherDao

    companion object {
        @Volatile private var instance: WeatherDatabase? = null
        private val Lock = Any()
        operator fun invoke(context:Context) = instance ?: synchronized(Lock){
            instance ?: buildDatabase(context).also { instance to it }
        }
        private fun buildDatabase(context: Context){
            Room.databaseBuilder(context.applicationContext,
                WeatherDatabase::class.java,"weather.db")
                .build()
        }
    }
}