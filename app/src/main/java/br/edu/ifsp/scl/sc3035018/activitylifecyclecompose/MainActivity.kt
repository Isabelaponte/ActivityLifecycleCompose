package br.edu.ifsp.scl.sc3035018.activitylifecyclecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import br.edu.ifsp.scl.sc3035018.activitylifecyclecompose.ui.theme.ActivityLifecycleComposeTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityLifecycleComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, mainViewModel: MainViewModel = viewModel()) {
    var name by rememberSaveable { mutableStateOf("" ) }
    var age by rememberSaveable  { mutableStateOf("" ) }

    Column (
        modifier = modifier.fillMaxSize()
    ) {
        TextField(
            value = mainViewModel.name, // responsabilidade do que será mostrado na tela fica no MODEL
            label = { Text("Name") },
            keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Text),
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            onValueChange = { mainViewModel.updateName(it) }
        )
        TextField(
            value = mainViewModel.age.toString(),
            label = { Text("Idade") },
            keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            onValueChange = { mainViewModel.updateAge(it.toIntOrNull()) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ActivityLifecycleComposeTheme {
        MainScreen()
    }
}