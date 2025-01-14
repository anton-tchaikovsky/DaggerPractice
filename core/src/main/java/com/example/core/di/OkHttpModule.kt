package com.example.core.di

import android.util.Log
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
interface OkHttpModule {
    companion object {
        @Singleton
        @Provides
        @SimpleOkHttpClient
        fun provideOkHttpClient(@SimpleInterceptor interceptor: Interceptor): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        @Singleton
        @Provides
        @LoggingOkHttpClient
        fun provideLoggingOkHttpClient(@LoggingInterceptor interceptor: Interceptor): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        @Singleton
        @Provides
        @SimpleInterceptor
        fun provideSimpleInterceptor(): Interceptor = Interceptor { chain ->
            chain.proceed(chain.request())
                .also { Log.d("OkHttpCatsFact", it.code.toString() + " " + it.message) }
        }

        @Singleton
        @Provides
        @LoggingInterceptor
        fun provideHttpLoggingInterceptor(): Interceptor =
            HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SimpleInterceptor()

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SimpleOkHttpClient()

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LoggingInterceptor()

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LoggingOkHttpClient()