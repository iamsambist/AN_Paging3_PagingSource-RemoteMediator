package com.sunaa.apikeycall.data

import com.sunaa.apikeycall.data.remote.JsonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CricService {
    @GET("players")
    suspend fun getPlayers(
        @Query("apikey") apiKey: String = "62087e8c-c5b8-491a-adf2-bd89ffb81dc3",
        @Query("offset") offset: Int
    ): Response<JsonResponse>

}