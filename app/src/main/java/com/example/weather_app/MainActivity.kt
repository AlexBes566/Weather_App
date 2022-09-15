package com.example.weather_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.layout.*
import androidx.core.content.ContextCompat
import com.example.weather_app.di.RetrofitModule
import com.example.weather_app.ui.main.CitySearch
import com.example.weather_app.utils.API_KEY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val weatherStatus: String = "Пасмурно"
    private val api: RetrofitModule ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = ContextCompat.getColor(this, R.color.black)
            CitySearch()
        }
    }
}

fun timeFormatter(): String {
    val timeSplit = SimpleDateFormat().format(Date())
    val time = timeSplit.split(" ")
    println("${time[0]} + ${timeSplit}")
    return time[1]
}