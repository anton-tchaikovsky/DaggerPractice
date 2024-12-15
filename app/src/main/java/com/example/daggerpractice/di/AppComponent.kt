package com.example.daggerpractice.di

import android.content.Context
import com.example.core.di.RetrofitModule
import com.example.core.di.ViewModelsFactoryModule
import com.example.feature_home.di.FactsRepositoryModule
import com.example.feature_home.di.FactsViewModelModule
import com.example.feature_home.di.FeatureHomeComponent
import com.example.feature_home.presentation.FactsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [ViewModelsFactoryModule::class, RetrofitModule::class,
        FactsViewModelModule::class, FactsRepositoryModule::class]
)
interface AppComponent : FeatureHomeComponent {

    override fun inject(fragment: FactsFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context): AppComponent
    }
}