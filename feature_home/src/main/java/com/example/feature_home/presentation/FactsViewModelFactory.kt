package com.example.feature_home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_home.di.FeatureHomeScope
import com.example.feature_home.domain.FactsRepository
import javax.inject.Inject

@FeatureHomeScope
class FactsViewModelFactory @Inject constructor (private val repository: FactsRepository) : ViewModelProvider.NewInstanceFactory() {

    init {
        Log.d("@@@", "InitFactsViewModelFactory")
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = FactsViewModel(repository)
        if (modelClass.isInstance(viewModel)) {
            @Suppress("UNCHECKED_CAST")
            return viewModel as T
        }
        throw IllegalArgumentException("Can not create viewModel for class: $modelClass")
    }
}