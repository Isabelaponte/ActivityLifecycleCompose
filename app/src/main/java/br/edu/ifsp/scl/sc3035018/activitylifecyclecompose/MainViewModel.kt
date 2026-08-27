package br.edu.ifsp.scl.sc3035018.activitylifecyclecompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(val savedStateHandle: SavedStateHandle): ViewModel() {
    private companion object { //singleton interno, funciona QUASE como um enum pra guardar constancia
        const val USER_KEY = "user"
    }

    private val _uiState = MutableStateFlow(savedStateHandle[USER_KEY] ?: User()) //tenta pegar o estado da ultima morte dele, se não ele monta um User vazio
    val uiState: StateFlow<User> = _uiState.asStateFlow() //somente get

    fun updateName(name: String ) {
        _uiState.update { it.copy(name = name) } // atualiza a tela
        savedStateHandle[USER_KEY] = _uiState.value.copy(name = name) // guarda os dados de instancia caso ele morra
        // savedStateHandle[USER_KEY] = (savedStateHandle[USER_KEY] as? User)?.copy(name = name) ?: User() // assim é melhor por nao estar fazendo gambiarra por pegar pelo state. dessa forma ele pega pelo get, mas por algum motivo ele nao está funcionando (talvez seja versao
        // savedStateHandle[USER_KEY] = savedStateHandle.get<User>(USER_KEY)?.copy(name = name) ?: User() //desse jeito funciona e é melhor
    }

    fun updateAge(age: Int?) {
        _uiState.update { it.copy(age = age) }
        savedStateHandle[USER_KEY] = _uiState.value.copy(age = age)
    }

}