package com.example.core.api

import com.example.core.data_entity.DogsFact
import retrofit2.http.GET

interface DogsFactApi: FactApi {
    @GET ("/api/v2/facts")
    suspend fun getFact(): DogsFact
}