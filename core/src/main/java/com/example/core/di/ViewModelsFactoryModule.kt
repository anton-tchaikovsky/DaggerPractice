package com.example.core.di

import androidx.lifecycle.ViewModelProvider
import com.example.core.utils.ViewModelsFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ViewModelsFactoryModule {
    @Singleton
    @Binds
    fun bindViewModelFactory(factory: ViewModelsFactory): ViewModelProvider.Factory
}