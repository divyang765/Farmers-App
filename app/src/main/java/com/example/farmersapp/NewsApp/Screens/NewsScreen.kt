package com.example.farmersapp.NewsApp.Screens

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.farmersapp.NewsApp.Activity.NewsDetailsActivity
import com.example.farmersapp.NewsApp.models.Article
import com.example.farmersapp.NewsApp.models.BottomNavigationItems
import com.example.farmersapp.NewsApp.models.NewsViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewsScreen(viewModel: NewsViewModel) {


    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(7, 63, 44, 255))
    ) {
        viewModel.NewsData.value.let { ShowNewsList(it, viewModel) }


    }


}

@Composable
fun ShowSearchBar(viewModel: NewsViewModel) {
    val context = LocalContext.current
    var searchText by remember {
        mutableStateOf("")
    }
    TextField(value = searchText, onValueChange = {
        searchText = it

    }, modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp), label = {
        Text(text = "Search", color = Color.White, fontWeight = FontWeight.Black)
    }, singleLine = true, maxLines = 1, leadingIcon = {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null, tint = Color.White
        )
    }, colors = TextFieldDefaults.colors(
        focusedContainerColor = Color(6, 53, 37, 255),
        unfocusedContainerColor = Color(6, 53, 37, 255),

        ), textStyle = TextStyle(color = Color.White, fontSize = 25.sp)
    )
    viewModel.fetchNewsData(searchText, context)
}

@Composable
fun ShowNewsList(article: List<Article>, viewModel: NewsViewModel) {
    val context = LocalContext.current
    Column {
        ShowSearchBar(viewModel = viewModel)
        LazyColumn {
            items(article) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {

                        val intent = Intent(context, NewsDetailsActivity::class.java).apply {
                            putExtra("url", it.url)
                            putExtra("title", it.title)
                            putExtra("image", it.image)
                            putExtra("description", it.description)
                        }
                        context.startActivity(intent)
                    }
                ) {
                    AsyncImage(
                        model = it.image,
                        contentDescription = it.title,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(150.dp)
                    )
                    Column(verticalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = it.title,
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(start = 10.dp)
                        )
                        Text(
                            text = it.source.name,
                            style = TextStyle(fontSize = 10.sp, color = Color.White),
                            modifier = Modifier.padding(start = 10.dp)
                        )
                        Text(
                            text = it.publishedAt,
                            style = TextStyle(fontSize = 10.sp, color = Color.White),
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }
            }
        }

    }
}

@Preview
@Composable

fun NewsScreenPreview() {
    NewsScreen(viewModel = NewsViewModel())
}