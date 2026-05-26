package com.example.task_manager.helper

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Helper {
    fun convertDate(date: Date):String{
        return SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(date)
    }
}