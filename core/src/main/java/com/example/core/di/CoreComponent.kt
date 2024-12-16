package com.example.core.di

import com.example.core.di.dependencies.CoreDependenciesApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [RetrofitModule::class])
interface CoreComponent: CoreDependenciesApi