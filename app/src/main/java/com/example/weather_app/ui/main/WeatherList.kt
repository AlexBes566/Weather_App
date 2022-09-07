package com.example.weather_app.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather_app.DataProvider

@Preview
@Composable
fun WeatherList() {
    val city = remember { DataProvider.citylistt }
    LazyColumn{
        items(
            items = city,
            itemContent = {
                WeatherCard(city = it)
            }
        )
    }
}