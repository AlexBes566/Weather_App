package com.example.weather_app.data.db.weather

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weather_app.models.local.Current
import java.time.Instant
import java.time.ZoneId

@Entity(tableName = "current_table")
data class DbCurrent(
    @PrimaryKey
    val cityId: Long,
    val date: Long,
    val tz: String,
    val sunrise: Long,
    val sunset: Long,
    val temp: Int,
    val feelsLike: Int,
    val pressure: Double,
    val humidity: Int,
    val dewPoint: Int,
    val clouds: Int,
    val uvi: Int,
    val visibility: Int,
    val windSpeed: Int,
    val windGust: Int,
    val windDeg: Int,
    val icon: String,
    val description: String
)

val directions by lazy { listOf("N", "NE", "E", "SE", "S", "SW", "W", "NW") }

fun degreeToDirection(deg: Int): String {
    return directions[(deg % 360) / 45]

}

@RequiresApi(Build.VERSION_CODES.O)
fun DbCurrent.asDomainModel(): Current {
    return Current(
        lastUpdated = Instant.ofEpochSecond(date).atZone(ZoneId.of(tz)),
        sunrise = Instant.ofEpochSecond(sunrise).atZone(ZoneId.of(tz)),
        sunset = Instant.ofEpochSecond(sunset).atZone(ZoneId.of(tz)),
        temp,
        feelsLike,
        pressure,
        humidity,
        dewPoint,
        clouds,
        uvi,
        visibility,
        windSpeed,
        windGust,
        degreeToDirection(windDeg),
        icon,
        description
    )
}