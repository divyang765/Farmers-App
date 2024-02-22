package com.example.farmersapp.NewsApp.models

data class Article(

    val description: String,
    val image: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String
)