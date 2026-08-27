package br.edu.ifsp.scl.sc3035018.activitylifecyclecompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(User()) //estado mutável será realizado pelo _uiState
    val uiState: StateFlow<User> = _uiState.asStateFlow() //somente get

    val x = mutableStateOf(0) //pq a mudança da estratégia? nao melhora desempenho, mas é melhor na arquitetura por causa da divisão de responsabilidades

    fun updateName(name: String ) {
        _uiState.value.name = name
    }

    fun updateAge(age: Int?) {
        _uiState.update { it.copy(age = age) } //forma melhor de realizar o set algo
    }

}