package com.example.feature_home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_home.data.dto.CatsFactDto
import com.example.feature_home.data.dto.DogsFactDto
import com.example.feature_home.domain.FactsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class FactsViewModel @Inject constructor(private val repository: FactsRepository) : ViewModel() {

    init {
        Log.d("@@@", "initViewModel")
    }

    private var catsFact: CatsFactDto? = null

    private var dogsFact: DogsFactDto? = null

    private val _factsStateScreen =
        MutableStateFlow<FactsScreenState>(FactsScreenState.SuccessFact())

    internal val factsScreenState: StateFlow<FactsScreenState>
        get() = _factsStateScreen

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