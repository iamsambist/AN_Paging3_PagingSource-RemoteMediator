package com.sunaa.apikeycall.data.remote

data class JsonResponse(
    val apikey: String,
    val `data`: List<Data>,
    val info: Info,
    val status: String
)