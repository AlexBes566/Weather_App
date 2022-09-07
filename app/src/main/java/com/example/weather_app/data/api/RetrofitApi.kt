package com.example.weather_app.data.api

import com.example.weather_app.models.network.CityName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApi {

    @GET("{city_name}&appid={api_key}&lang=ru")
    fun getCityDataList(@Path ("city_name") city_name: String,
                        @Path ("api_key") api_key: String): Call<CityName>
}