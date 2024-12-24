package com.example.core.di.dependencies

import com.example.core.logger.Logger
import retrofit2.Retrofit
import java.util.Optional

interface CoreDependenciesApi {
    fun getRetrofit(): Map<String, Retrofit>

    fun getLogger(): Optional<Logger>
}