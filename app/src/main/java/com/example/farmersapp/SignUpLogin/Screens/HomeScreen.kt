package com.example.farmersapp.SignUpLogin.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import com.example.farmersapp.App.Screen
import com.example.farmersapp.NewsApp.Screens.ApmcScreen
import com.example.farmersapp.NewsApp.Screens.FavouriteScreen
import com.example.farmersapp.NewsApp.Screens.NewsScreen
import com.example.farmersapp.NewsApp.Screens.WeatherScreen
import com.example.farmersapp.NewsApp.models.BottomNavigationItems
import com.example.farmersapp.NewsApp.models.NewsViewModel
import com.example.farmersapp.SignUpLogin.ButtonComponent
import com.example.farmersapp.SignUpLogin.HeadingTextComponent
import com.example.farmersapp.SignUpLogin.ViewModels.SignInViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(signInViewModel: SignInViewModel = SignInViewModel()) {

    val items = listOf(
        BottomNavigationItems(
            title = "News",
            selectedIcon = Icons.Filled.Newspaper,
            unSelectedIcon = Icons.Outlined.Newspaper,

            ),
        BottomNavigationItems(
            title = "Favourites",
            selectedIcon = Icons.Filled.Favorite,
            unSelectedIcon = Icons.Outlined.Favorite,

            ),
        BottomNavigationItems(
            title = "Weather",
            selectedIcon = Icons.Filled.WbSunny,
            unSelectedIcon = Icons.Outlined.WbSunny,

            ),
        BottomNavigationItems(
            title = "Apmc Prices",
            selectedIcon = Icons.Filled.AttachMoney,
            unSelectedIcon = Icons.Outlined.AttachMoney,

            ),
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
//            .background(Color.White)
//            .padding(28.dp)
    ) {
        val navController = rememberNavController()
        Scaffold(bottomBar = {
            NavigationBar(containerColor = Color(6, 53, 37, 255)) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.title)
                        },
                        label = { Text(text = item.title, color = Color.White) },
                        icon = {

                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else {
                                    item.unSelectedIcon
                                }, contentDescription = item.title,
                                tint = Color.White
                            )
                        })

                }
            }
        }) {
            NavHost(navController = navController, startDestination = "News") {
                composable("News") {
                    NewsScreen(
                        viewModel = NewsViewModel()

                    )

                }
                composable("Weather") {
                    WeatherScreen()
                }
                composable("Apmc Prices") {
                    ApmcScreen()
                }
                composable("Favourites") {
                    FavouriteScreen()
                }
            }
        }

    }
}