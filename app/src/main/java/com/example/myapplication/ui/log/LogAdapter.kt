package com.example.myapplication.ui.log

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class LogAdapter(private val logs:ArrayList<Log>): RecyclerView.Adapter<LogHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogHolder {
        return LogHolder(LayoutInflater.from(parent.context).inflate(R.layout.li_log,parent,false))
    }

    override fun getItemCount() = logs.size

    override fun onBindViewHolder(holder: LogHolder, position: Int) {
        holder.tvTime.text = logs[position].time
        holder.tvTemp.text = logs[position].temp
    }

}