package com.example.farmersapp.NewsApp.Screens


import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.farmersapp.WeatherApp.WeatherActivity


@Composable
fun WeatherScreen() {
    val context = LocalContext.current

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                context.startActivity(Intent(context, WeatherActivity::class.java))

            },
            colors = ButtonColors(
                containerColor = Color(7, 63, 44, 255),
                contentColor = Color.White,
                disabledContainerColor = Color(7, 63, 44, 255),
                disabledContentColor = Color.White

            ), modifier = Modifier.height(50.dp)
        ) {
            Text(text = "Get Latest Weather")
        }
    }
}