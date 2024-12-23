package com.example.feature_home.presentation

import com.example.feature_home.data.dto.CatsFactDto
import com.example.feature_home.data.dto.DogsFactDto

internal sealed interface FactsScreenState {
    class SuccessFact(
        val factsCat: CatsFactDto,
        val factsDog: DogsFactDto
    ) : FactsScreenState

    class Error(val error: String) : FactsScreenState

    data object Loading : FactsScreenState
}