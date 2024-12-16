package com.example.core.di.dependencies

import retrofit2.Retrofit

interface CoreDependenciesApi {
    fun getRetrofit(): Map<String, Retrofit>
}