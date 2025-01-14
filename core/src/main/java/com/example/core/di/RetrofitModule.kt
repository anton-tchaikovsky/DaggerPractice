package com.example.core.di

import com.example.core.logger.Logger
import dagger.BindsOptionalOf
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
interface RetrofitModule {

    @BindsOptionalOf
    fun bindLogger(): Logger

    companion object {
        @Singleton
        @Provides
        fun provideLogger(): Logger = object : Logger {}

        @Singleton
        @Provides
        @IntoMap
        @StringKey(CATS_FACT_API_STRING_KEY)
        fun provideCatRetrofit(@SimpleOkHttpClient client: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl("https://catfact.ninja")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        @Singleton
        @Provides
        @IntoMap
        @StringKey(DOGS_FACT_API_STRING_KEY)
        fun provideDogRetrofit(@LoggingOkHttpClient client: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl("https://dogapi.dog")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

const val CATS_FACT_API_STRING_KEY = "Cat"
const val DOGS_FACT_API_STRING_KEY = "Dog"