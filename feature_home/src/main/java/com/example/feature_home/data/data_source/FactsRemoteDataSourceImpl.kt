package com.example.feature_home.data.data_source

import android.util.Log
import com.example.core.api.CatsFactApi
import com.example.core.api.DogsFactApi
import com.example.core.data_entity.CatsFact
import com.example.core.data_entity.DogsFact
import com.example.core.di.CATS_FACT_API_STRING_KEY
import com.example.core.di.DOGS_FACT_API_STRING_KEY
import com.example.core.logger.Logger
import retrofit2.Retrofit
import java.util.Optional
import javax.inject.Inject


class FactsRemoteDataSourceImpl @Inject constructor(private val retrofit: Map<String, Retrofit>, logger: Optional<Logger>):
    FactsRemoteDataSource {

    init {
        Log.d("@@@", "initDataSource")
        Log.d ("@@@", "Logger isPresent: ${logger.isPresent}")

    }

    override suspend fun getCatsFact(): CatsFact =
        retrofit[CATS_FACT_API_STRING_KEY]?.create(CatsFactApi::class.java)?.getFact() ?: throw IllegalStateException()


    override suspend fun getDogsFact(): DogsFact =
       retrofit[DOGS_FACT_API_STRING_KEY]?.create(DogsFactApi::class.java)?.getFact() ?: throw IllegalStateException()

}