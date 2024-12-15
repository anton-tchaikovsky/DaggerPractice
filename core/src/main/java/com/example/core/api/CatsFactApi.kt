package com.example.core.api

import com.example.core.data_entity.CatsFact
import retrofit2.http.GET

interface CatsFactApi: FactApi {
    @GET ("/fact")
    suspend fun getFact(): CatsFact
}