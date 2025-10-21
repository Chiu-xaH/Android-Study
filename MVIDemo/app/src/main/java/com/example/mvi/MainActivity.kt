package com.example.mvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvi.ui.theme.MVIDemoTheme
// Activity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVIDemoTheme {
                CounterScreen()
            }
        }
    }
}
// Model(M)
data class CounterState(
    val count : Int = 0
)
// Intent(I)
sealed class CounterIntent {
    object Increment : CounterIntent()
    object Decrement : CounterIntent()
}
// ViewModel
class CounterViewModel() : ViewModel() {
    private val _state = mutableStateOf(CounterState(0))
    val state : State<CounterState> = _state

    fun process(intent : CounterIntent) {
        _state.value  = when(intent) {
            CounterIntent.Increment -> state.value.copy(count = _state.value.count+1)
            CounterIntent.Decrement -> state.value.copy(count = _state.value.count-1)
        }
    }
}
// View(V)
@Composable
fun CounterScreen(
    viewModel: CounterViewModel = viewModel()
) {
    val state by remember { viewModel.state }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text("Count: ${state.count}", style = MaterialTheme.typography.titleLarge)
            Row {
                Button(onClick = { viewModel.process(CounterIntent.Increment) }) { Text("+") }
                Spacer(modifier = Modifier.width(15.dp))
                Button(onClick = { viewModel.process(CounterIntent.Decrement) }) { Text("-") }
            }
        }
    }
}