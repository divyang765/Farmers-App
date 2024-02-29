package com.example.farmersapp.NewsApp.Activity

import android.app.ActionBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.farmersapp.NewsApp.Activity.ui.theme.FarmersAppTheme
import com.example.farmersapp.NewsApp.Screens.NewsDetailsScreen


class NewsDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()

        setContent {
            FarmersAppTheme {
                // A surface container using the 'background' color from the theme

                NewsDetailsScreen(this)

            }
        }
    }
}


