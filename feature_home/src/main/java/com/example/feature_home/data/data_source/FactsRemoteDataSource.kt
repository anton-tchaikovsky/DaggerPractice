package com.example.feature_home.data.data_source

import com.example.core.data_entity.CatsFact
import com.example.core.data_entity.DogsFact

interface FactsRemoteDataSource {
    suspend fun getCatsFact(): CatsFact

    suspend fun getDogsFact(): DogsFact
}