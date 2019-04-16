package com.example.myapplication.ui.log

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fr_logs.*

class LogFragment:Fragment() {

    companion object{
        fun newInstance(): LogFragment {
            val fragment = LogFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v:View = inflater.inflate(R.layout.fr_logs,container,false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var dataSet:ArrayList<Log> = ArrayList<Log>()
        dataSet.add(Log("12","13"))
        dataSet.add(Log("13","14"))
        dataSet.add(Log("14","15"))
        var adapter:LogAdapter = LogAdapter(dataSet)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(context)


    }

}