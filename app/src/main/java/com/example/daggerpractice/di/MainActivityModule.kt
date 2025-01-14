package com.example.daggerpractice.di

import com.example.feature_home.di.FactsFragmentModule
import com.example.feature_home.presentation.FactsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(modules = [FactsFragmentModule::class])
    fun contributeFactsFragment(): FactsFragment
}