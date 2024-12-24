package com.example.feature_home.di.dependencies

import com.example.core.logger.Logger
import retrofit2.Retrofit
import java.util.Optional

interface FeatureHomeDependenciesProvider {
    fun getRetrofit(): Map<String,Retrofit>

    fun getLogger(): Optional<Logger>
}