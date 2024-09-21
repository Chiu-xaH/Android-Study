package com.chiuxah.fragmenttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chiuxah.fragmenttest.ui.theme.FragmentTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment)
        val fragment = FishPureFragment()
        fragment.arguments = Bundle().apply {
            putString("hello", "fragment:${count++}")
        }
        supportFragmentManager.beginTransaction().add(R.id.root, fragment).commitNow()
    }
}
