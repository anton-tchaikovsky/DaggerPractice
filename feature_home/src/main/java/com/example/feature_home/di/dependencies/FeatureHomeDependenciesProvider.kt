package com.example.feature_home.di.dependencies

import retrofit2.Retrofit

interface FeatureHomeDependenciesProvider {
    fun getRetrofit(): Map<String,Retrofit>
}