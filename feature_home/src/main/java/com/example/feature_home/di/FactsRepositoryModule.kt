package com.example.feature_home.di

import com.example.feature_home.data.FactsRepositoryImpl
import com.example.feature_home.domain.FactsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [FactsDataSourceModule::class])
interface FactsRepositoryModule {
    @Singleton
    @Binds
    fun bindRepository(repositoryImpl: FactsRepositoryImpl): FactsRepository
}