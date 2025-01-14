package com.example.daggerpractice.di

import android.content.Context
import com.example.core.di.dependencies.CoreDependenciesApi
import com.example.daggerpractice.DaggerPracticeApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class],
    dependencies = [CoreDependenciesApi::class]
)
interface AppComponent: CoreDependenciesApi {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(context: Context): Builder

        fun coreDependenciesApi(dependenciesApi: CoreDependenciesApi): Builder

        fun build(): AppComponent
    }

    fun inject(app: DaggerPracticeApplication)
}