package com.example.weather_app.ui.main

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val Typography.shadowTextStyle20sp: TextStyle
    @Composable
    get() {
        val offset = Offset(3.0f, 4.0f)
        return TextStyle(
            fontSize = 20.sp,
            shadow = Shadow(
                color = Color.Black,
                offset = offset,
                blurRadius = 6f
            )
        )
    }