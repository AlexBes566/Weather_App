package com.example.weather_app.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.City
import com.example.weather_app.R
import com.example.weather_app.timeFormatter

@Composable
fun WeatherCard(
    city: City
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = colorResource(id = R.color.purple_500)
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = city.city,
                modifier = Modifier.padding(15.dp, 15.dp, 0.dp, 0.dp),
                fontFamily = FontFamily.Default,
                fontSize = 20.sp,
                color = Color.White,
                style = MaterialTheme.typography.shadowTextStyle20sp
            )
            Text(
                text = timeFormatter(),
                modifier = Modifier.padding(15.dp, 5.dp, 0.dp, 0.dp),
                fontFamily = FontFamily.Default,
                fontSize = 12.sp,
                color = Color.White,
                style = MaterialTheme.typography.shadowTextStyle20sp,
            )
            Text(
                text = city.weatherStatus,
                fontFamily = FontFamily.Default,
                modifier = Modifier.padding(15.dp, 20.dp, 0.dp, 0.dp),
                fontSize = 12.sp,
                color = Color.White,
                style = MaterialTheme.typography.shadowTextStyle20sp
            )
        }
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxWidth(0.5F)
        ) {
            Text(
                text = "${city.temp}\u00B0",
                modifier = Modifier.padding(0.dp, 15.dp, 30.dp, 0.dp),
                fontFamily = FontFamily.Default,
                fontSize = 35.sp,
                color = Color.White,
                style = MaterialTheme.typography.shadowTextStyle20sp
            )
            Row(
                modifier = Modifier.padding(0.dp, 23.dp, 15.dp, 0.dp),
            ) {
                Text(
                    text = "Макс.:${city.maxTemp}°",
                    fontFamily = FontFamily.Default,
                    fontSize = 12.sp,
                    color = Color.White,
                    style = MaterialTheme.typography.shadowTextStyle20sp
                )
                Text(
                    text = "Мин.:${city.minTemp}°",
                    fontFamily = FontFamily.Default,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.shadowTextStyle20sp
                )
            }
        }
    }

}