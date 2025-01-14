package com.example.feature_home.di

import com.example.feature_home.data.data_source.FactsRemoteDataSource
import com.example.feature_home.data.data_source.FactsRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface FactsDataSourceModule {
    @Binds
    fun bindRemoteDataSource(dataSource: FactsRemoteDataSourceImpl): FactsRemoteDataSource
}