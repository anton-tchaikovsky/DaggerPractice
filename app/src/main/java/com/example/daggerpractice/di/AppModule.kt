package com.example.daggerpractice.di

import com.example.daggerpractice.MainActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module (includes = [AndroidInjectionModule::class])
interface AppModule {
    @ContributesAndroidInjector (modules = [MainActivityModule::class])
    fun contributeMainActivity(): MainActivity
}