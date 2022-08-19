package com.example.weather_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        }
    }
}

fun timeFormatter(): String {
    val timeSplit = SimpleDateFormat().format(Date())
    val time = timeSplit.split(",")
    return time[1]
}

@Composable
fun CitySearch() {
    val inputCity = remember {
        mutableStateOf(TextFieldValue.toString())
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
            placeholder = { Text(text = "Введите название города", color = Color.Gray)},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Text
            ),
            textStyle = TextStyle(
                color = Color.Black,
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
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WeatherBoard(
    city: String,
    time: String,
    temp: Int,
    maxTemp: Int,
    minTemp: Int,
    weatherStatus: String
) {
    Card(
        onClick = { weatherStatus },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(120.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = colorResource(id = R.color.purple_500)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.5F),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = city,
                modifier = Modifier.padding(15.dp, 10.dp),
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.shadowTextStyle20sp
            )
            Text(
                text = time,
                fontFamily = FontFamily.Default,
                modifier = Modifier.padding(15.dp),
                fontSize = 10.sp,
                color = Color.White,
                style = MaterialTheme.typography.shadowTextStyle20sp
            )
            Text(
                text = weatherStatus,
                fontFamily = FontFamily.Default,
                modifier = Modifier.padding(15.dp),
                fontSize = 10.sp,
                color = Color.White,
                style = MaterialTheme.typography.shadowTextStyle20sp
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = temp.toString(),
                modifier = Modifier.padding(15.dp, 10.dp),
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.shadowTextStyle20sp
            )
            Text(
                text = maxTemp.toString(),
                fontFamily = FontFamily.Default,
                modifier = Modifier.padding(15.dp),
                fontSize = 10.sp,
                color = Color.White,
                style = MaterialTheme.typography.shadowTextStyle20sp
            )
        }
    }

}

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

@Preview
@Composable
fun WeatherListPreview() {
    WeatherBoard(
        "Орск",
        time = timeFormatter(),
        temp = 22,
        maxTemp = 25,
        minTemp = 20,
        weatherStatus = "Прохладно"
    )
}