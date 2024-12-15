package com.example.daggerpractice

import android.app.Application
import com.example.daggerpractice.di.AppComponent
import com.example.daggerpractice.di.DaggerAppComponent
import com.example.feature_home.di.FeatureHomeComponent
import com.example.feature_home.di.FeatureHomeDependenciesProvider

class DaggerPracticeApplication: Application(), FeatureHomeDependenciesProvider {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }

    override fun getFeatureHomeComponent(): FeatureHomeComponent = appComponent
}