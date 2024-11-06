package com.sunaa.apikeycall.data.repo

import com.sunaa.apikeycall.data.CricService
import com.sunaa.apikeycall.data.remote.JsonResponse
import retrofit2.Response
import javax.inject.Inject

class CrickRepoImp @Inject constructor(
    private val service: CricService
) {
    suspend fun getPlayers(page : Int) : Response<JsonResponse> {
        return service.getPlayers(offset = page)
    }
}