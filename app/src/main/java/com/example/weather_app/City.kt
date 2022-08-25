package com.example.weather_app

data class City(
    val city: String,
    val temp: Int,
    val maxTemp: Int,
    val minTemp: Int,
    val weatherStatus: String,
)