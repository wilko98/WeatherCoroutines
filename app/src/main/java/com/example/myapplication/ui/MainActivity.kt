package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.myapplication.R
import com.example.myapplication.ui.log.LogFragment
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    var apiServise: Any? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main)
        changeFragment(WeatherFragment.newInstance())
    }

    fun changeFragment(fragment: Fragment){
        var fm: FragmentManager = supportFragmentManager
        fm
            .beginTransaction()
            .replace(R.id.container,fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.logs -> {
                changeFragment(LogFragment.newInstance())
                return true
            }
            R.id.current ->{
                changeFragment(WeatherFragment.newInstance())
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
