package com.example.apmcprices.DataClass

data class ApmcRecords(
    val state: String,
    val district: String,
    val market: String,
    val commodity: String,
    val min_price: String,
    val max_price: String,
    val modal_price: String,
    val arrival_date: String
)
