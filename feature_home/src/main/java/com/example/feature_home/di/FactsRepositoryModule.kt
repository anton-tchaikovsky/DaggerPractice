package com.example.feature_home.di

import com.example.feature_home.data.FactsRepositoryImpl
import com.example.feature_home.domain.FactsRepository
import dagger.Binds
import dagger.Module

@Module(includes = [FactsDataSourceModule::class])
interface FactsRepositoryModule {
    @FeatureHomeScope
    @Binds
    fun bindRepository(repositoryImpl: FactsRepositoryImpl): FactsRepository
}