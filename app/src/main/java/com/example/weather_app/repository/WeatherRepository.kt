package com.example.weather_app.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import com.example.weather_app.data.api.RetrofitApi
import com.example.weather_app.data.db.city.CityDataBaseDao
import com.example.weather_app.data.db.city.asDomainModel
import com.example.weather_app.data.db.weather.WeatherDataBaseDao
import com.example.weather_app.data.db.weather.asDomainModel
import com.example.weather_app.di.RetrofitModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

sealed class RefreshState {
    object Loading : RefreshState()
    object Loaded : RefreshState()
    object PermissionError : RefreshState()
    data class Error(@StringRes val message: Int) : RefreshState()
}

class WeatherRepository (
    private val weatherDb: WeatherDataBaseDao,
    private val cityDb: CityDataBaseDao,
    private val api: RetrofitModule,
        ) {

    @RequiresApi(Build.VERSION_CODES.O)
    val currentForecast =
        weatherDb.getCurrentForecast().map {
            it?.asDomainModel()
        }.stateIn(CoroutineScope(Dispatchers.IO), SharingStarted.Eagerly, null)

    val savedCities =
        cityDb.getSavedCities().map {
            it.asDomainModel()
        }.stateIn(CoroutineScope(Dispatchers.IO), SharingStarted.Eagerly, emptyList())

    private fun getWeather(cityId: Long) {
        CoroutineScope(Dispatchers.IO).launch {

        }
    }
}