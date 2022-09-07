package com.example.weather_app.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion.toString
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.R

@Composable
fun CitySearch() {
    val inputCity = remember {
        mutableStateOf(toString())
    }
    Column(
        modifier = Modifier
            .fillMaxSize(1F)
            .background(Color.Black)
            .padding(10.dp)
    ) {
        Text(text = stringResource(id = R.string.weather),
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp),
            color = Color.White,
        )
        OutlinedTextField(value = "",
            onValueChange = {
                    newValue -> inputCity.value = newValue
            },
            modifier = Modifier.fillMaxWidth(),
            //placeholder = { Text(text = "Введите название города", color = Color.Gray)},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Text
            ),
            textStyle = TextStyle(
                color = Color.White,
                fontFamily = FontFamily.SansSerif
            ),
            maxLines = 1,
            singleLine = true,
            leadingIcon = {
                Icon(Icons.Filled.Search,"text", tint = Color.Gray)
            },
            shape = CircleShape,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.raisin_black),
                backgroundColor = colorResource(id = R.color.raisin_black)
            )
        )
        WeatherList()
    }
}