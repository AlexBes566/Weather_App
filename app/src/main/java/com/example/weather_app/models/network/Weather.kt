package com.example.weather_app.models.network

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)