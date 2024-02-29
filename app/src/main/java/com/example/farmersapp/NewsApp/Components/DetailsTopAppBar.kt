package com.example.farmersapp.NewsApp.Components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.farmersapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onFavouriteClicked: () -> Unit,

    onShareClicked: () -> Unit,

    onBrowseClicked: () -> Unit,
    onBackClicked: () -> Unit,

) {

    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(6, 53, 37, 255),
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White

        ),
        navigationIcon = {

            IconButton(onClick = onBackClicked) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier

                        .padding(10.dp)
                )
            }


        },
        actions = {
            IconButton(onClick = onFavouriteClicked) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier

                        .padding(10.dp)
                )
            }
            IconButton(onClick = onShareClicked) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    modifier = Modifier

                        .padding(10.dp)
                )
            }
            IconButton(onClick = onBrowseClicked) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_open_in_browser_24),
                    contentDescription = null,
                    modifier = Modifier

                        .padding(10.dp)
                )
            }


        })

}


@Composable
@Preview(showBackground = true)
fun ShowTopAppBar() {
    DetailsTopBar(
        onFavouriteClicked = {},
        onShareClicked = {},
        onBrowseClicked = {},
        onBackClicked = {}
    )


}
