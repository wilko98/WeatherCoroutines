package com.example.myapplication.ui.log

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.li_log.view.*

class LogHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvTemp = view.temp
    val tvTime = view.time
}