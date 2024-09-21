package com.hfut.dynamiccolordemo

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.hfut.dynamiccolordemo.PrefHelper.get
import com.hfut.dynamiccolordemo.PrefHelper.operation
import com.hfut.dynamiccolordemo.PrefHelper.put
import com.hfut.dynamiccolordemo.ui.theme.DynamicColorDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var dynamicColorEnabled by remember { mutableStateOf(true) }
            val currentTheme by mainViewModel.currentTheme
            DynamicColorDemoTheme ( context = applicationContext,
                currentTheme = currentTheme,
                dynamicColor = dynamicColorEnabled){
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        mainViewModel = mainViewModel,
                        dynamicColorEnabled = dynamicColorEnabled,
                        onChangeDynamicColorEnabled = { dynamicColorEnabled = it }
                    )
                }
            }
        }
    }
}

