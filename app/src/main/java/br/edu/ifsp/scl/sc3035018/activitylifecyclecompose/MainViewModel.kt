package br.edu.ifsp.scl.sc3035018.activitylifecyclecompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var name by mutableStateOf("")
        private set

    var age by mutableIntStateOf(0)
        private set

    fun updateName(name: String ) {
        this.name = name
    }

    fun updateAge(age: Int?) {
        this.age = age ?: 0
    }

}