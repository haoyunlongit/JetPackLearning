package com.example.jetpack.model
data class BannerData(
    val `data`: List<Data>,
    val status: Int
)

data class Data(
    val image: String,
    val title: String,
    val url: String
)