package com.example.feature_home.domain

import com.example.feature_home.data.dto.CatsFactDto
import com.example.feature_home.data.dto.DogsFactDto

interface FactsRepository {
    suspend fun getCatsFact(): CatsFactDto

    suspend fun getDogsFact(): DogsFactDto
}