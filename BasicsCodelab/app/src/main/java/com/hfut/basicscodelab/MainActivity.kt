package com.hfut.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hfut.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expand = remember {
        mutableStateOf(false)
    }
    val extraPadding = if (expand.value) 48.dp else 0.dp
    Column(
        modifier = Modifier
            .padding(24.dp)
            .padding(bottom = extraPadding)
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        ElevatedButton(
            onClick = { expand.value = !expand.value },
            modifier = Modifier.shadow(50.dp),
        ) {
            Text(if (expand.value) "1" else "2")
        }
    }
    @Composable
    fun Start(modifier: Modifier = Modifier) {
        var should by remember { mutableStateOf(true) }
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("欢迎")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = { should = false }
            ) {
                Text("按钮")
            }
        }
    }

    @Composable
    fun MyApp(modifier: Modifier =  Modifier) {
        var should by remember { mutableStateOf(true) }
        Surface(modifier) {
            if(should) Start() else
        Greeting("Android")

        }
    }
}