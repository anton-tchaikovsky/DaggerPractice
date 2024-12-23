package com.example.feature_home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_home.data.dto.CatsFactDto
import com.example.feature_home.data.dto.DogsFactDto
import com.example.feature_home.di.FeatureHomeComponent
import com.example.feature_home.domain.FactsRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FactsViewModel @AssistedInject constructor(
    private val repository: FactsRepository,
    @Assisted
    private var catsFact: CatsFactDto,
    @Assisted
    private var dogsFact: DogsFactDto
) : ViewModel() {

    init {
        Log.d("@@@", "initViewModel")
    }

    @AssistedFactory
    interface Factory{
        fun create(catsFact: CatsFactDto, dogsFact: DogsFactDto): FactsViewModel
    }

    private val _factsStateScreen =
        MutableStateFlow<FactsScreenState>(FactsScreenState.SuccessFact(catsFact, dogsFact))

    internal val factsScreenState: StateFlow<FactsScreenState>
        get() = _factsStateScreen

    override fun onCleared() {
        FeatureHomeComponent.clearComponent()
        super.onCleared()
    }

    fun onCatsFactRequest() {
        _factsStateScreen.value = FactsScreenState.Loading
        viewModelScope.launch {
            try {
                _factsStateScreen.value = FactsScreenState.SuccessFact(
                    repository.getCatsFact().also { catsFact = it },
                    dogsFact
                )
            } catch (e: Throwable) {
                _factsStateScreen.value = FactsScreenState.Error(e.message.toString())
            }
        }
    }

    fun onDogsFactRequest() {
        _factsStateScreen.value = FactsScreenState.Loading
        viewModelScope.launch {
            try {
                _factsStateScreen.value = FactsScreenState.SuccessFact(
                    catsFact,
                    repository.getDogsFact().also { dogsFact = it })
            } catch (e: Throwable) {
                _factsStateScreen.value = FactsScreenState.Error(e.message.toString())
            }
        }
    }
}