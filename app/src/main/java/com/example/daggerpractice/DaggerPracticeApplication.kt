package com.example.daggerpractice

import android.app.Application
import com.example.core.di.DaggerCoreComponent
import com.example.daggerpractice.di.AppComponent
import com.example.daggerpractice.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class DaggerPracticeApplication : Application(),
    HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        val coreComponent = DaggerCoreComponent.create()
        appComponent =
            DaggerAppComponent.builder().coreDependenciesApi(coreComponent).applicationContext(this)
                .build().also {
                it.inject(this)
            }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}