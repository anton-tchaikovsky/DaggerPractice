package com.example.core.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
    @Singleton
    @Provides
    @IntoMap
    @StringKey(CATS_FACT_API_STRING_KEY)
    fun provideCatRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://catfact.ninja")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    @IntoMap
    @StringKey(DOGS_FACT_API_STRING_KEY)
    fun provideDogRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://dogapi.dog")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

const val CATS_FACT_API_STRING_KEY = "Cat"
const val DOGS_FACT_API_STRING_KEY = "Dog"