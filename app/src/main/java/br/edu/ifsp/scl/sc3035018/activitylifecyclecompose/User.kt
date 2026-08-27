package br.edu.ifsp.scl.sc3035018.activitylifecyclecompose

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize //faz com que os dados de instancia do viewmodel sobrevivam a morte do processo (nenhuma das outras estrategias utilizadas anteriormente faziam isso)
data class User(
    var name: String = "",
    var age: Int? = 0
): Parcelable
