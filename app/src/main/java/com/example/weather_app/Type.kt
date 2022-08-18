package com.example.weather_app

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class Type {
    val fonts = FontFamily(
        Font(R.font.roboto_black),
        Font(R.font.roboto_bold, weight = FontWeight.Bold),
        Font(R.font.roboto_light, weight = FontWeight.Light),
        Font(R.font.roboto_medium, weight = FontWeight.Medium),
    )

    val Typography = androidx.compose.material.Typography(
        body1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        h1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        ),
        h2 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp
        ),
        h3 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
    )
}