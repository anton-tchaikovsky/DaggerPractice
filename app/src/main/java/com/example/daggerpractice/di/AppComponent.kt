package com.example.daggerpractice.di

import com.example.core.di.dependencies.CoreDependenciesApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CoreDependenciesApi::class]
)
interface AppComponent: CoreDependenciesApi {

    @Component.Builder
    interface Builder {
        fun coreDependenciesApi(dependenciesApi: CoreDependenciesApi): Builder

        fun build(): AppComponent
    }
}