package com.example.feature_home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feature_home.data.dto.CatsFactDto
import com.example.feature_home.data.dto.DogsFactDto
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class FactsViewModelFactory @AssistedInject constructor(
    private val factsViewModelFactor: FactsViewModel.Factory,
    @Assisted
    private var catsFact: CatsFactDto,
    @Assisted
    private var dogsFact: DogsFactDto
) : ViewModelProvider.NewInstanceFactory() {

    init {
        Log.d("@@@", "InitFactsViewModelFactory")
    }

    @AssistedFactory
    interface Factory {
        fun create(catsFact: CatsFactDto, dogsFact: DogsFactDto): FactsViewModelFactory
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = factsViewModelFactor.create(catsFact, dogsFact)
        if (modelClass.isInstance(viewModel)) {
            @Suppress("UNCHECKED_CAST")
            return viewModel as T
        }
        throw IllegalArgumentException("Can not create viewModel for class: $modelClass")
    }
}