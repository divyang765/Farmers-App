package com.example.farmersapp.NewsApp.models

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class NewsViewModel : ViewModel() {

    val _NewsData = mutableStateOf<List<Article>>(emptyList())
    val NewsData: androidx.compose.runtime.State<List<Article>> = _NewsData


    private val API_KEY = "73b4920b4bc7ede85954efd4b238e3f4"

    fun fetchNewsData(newsQuery: String, context: Context) {
        val newsList = mutableListOf<Article>()
        val categoryNews: String = newsQuery.ifEmpty {
            "Farming"
        }
        val url = "https://gnews.io/api/v4/search?q=$categoryNews&lang=en&apikey=${API_KEY}"
        val JsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, {
                val jsonArray = it.getJSONArray("articles")

                for (i in 0 until jsonArray.length()) {
                    val articleJsonObject = jsonArray.getJSONObject(i)
                    val sourceJsonObject = articleJsonObject.getJSONObject("source")
                    val source = Source(name = sourceJsonObject.getString("name"))
                    val article = Article(
                        description = articleJsonObject.getString("description"),
                        image = articleJsonObject.getString("image"),
                        publishedAt = articleJsonObject.getString("publishedAt"),
                        source = source,
                        title = articleJsonObject.getString("title"),
                        url = articleJsonObject.getString("url")


                    )
                    newsList.add(article)
                    _NewsData.value = newsList
                }

            }, {

            }

        )
        Volley.newRequestQueue(context).add(JsonObjectRequest)

    }
}