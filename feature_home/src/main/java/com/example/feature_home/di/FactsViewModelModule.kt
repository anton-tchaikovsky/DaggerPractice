package com.example.feature_home.di

import androidx.lifecycle.ViewModel
import com.example.core.di.ViewModelKey
import com.example.feature_home.presentation.FactsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FactsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FactsViewModel::class)
    fun bindFactsViewModel(viewModel: FactsViewModel): ViewModel
}