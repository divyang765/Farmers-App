package com.example.farmersapp.NewsApp.Screens

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.farmersapp.NewsApp.Components.DetailsTopBar

@Composable
fun NewsDetailsScreen(activity: Activity) {
    val url = activity.intent.getStringExtra("url") ?: ""
    val image = activity.intent.getStringExtra("image") ?: ""
    val title = activity.intent.getStringExtra("title") ?: ""
    val description = activity.intent.getStringExtra("description") ?: ""
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(7, 63, 44, 255))
    ) {
        DetailsTopBar(
            onFavouriteClicked = { /*TODO*/ },
            onShareClicked = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    putExtra(
                        Intent.EXTRA_TEXT, url

                    )
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(intent, null)
                activity.startActivity(shareIntent)
            },
            onBackClicked = { activity.finish() },
            onBrowseClicked = {
                val browse_intent = CustomTabsIntent.Builder().build()
                browse_intent.launchUrl(activity, Uri.parse(url))
            },
        )


        NewsContent(image = image, title = title, description = description)
    }

}


@Composable
fun NewsContent(image: String, title: String, description: String) {
    Column {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(bottom = 10.dp)
        )

        Text(
            text = title,
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White),
            modifier = Modifier.padding(start = 10.dp, bottom = 10.dp)
        )

        Text(
            text = description,
            style = TextStyle(fontSize = 17.sp, color = Color.White),
            modifier = Modifier.padding(start = 10.dp, bottom = 10.dp)
        )

    }

}

