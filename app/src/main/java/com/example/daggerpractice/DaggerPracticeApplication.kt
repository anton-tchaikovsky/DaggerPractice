package com.example.daggerpractice

import android.app.Application
import com.example.core.di.DaggerCoreComponent
import com.example.core.logger.Logger
import com.example.daggerpractice.di.AppComponent
import com.example.daggerpractice.di.DaggerAppComponent
import com.example.feature_home.di.dependencies.FeatureHomeDependenciesProvider
import retrofit2.Retrofit
import java.util.Optional

class DaggerPracticeApplication : Application(), FeatureHomeDependenciesProvider {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        val coreComponent = DaggerCoreComponent.create()
       appComponent = DaggerAppComponent.builder().coreDependenciesApi(coreComponent).applicationContext(this).build()
    }

    override fun getRetrofit(): Map<String, Retrofit> = appComponent.getRetrofit()

    override fun getLogger(): Optional<Logger> = appComponent.getLogger()
}