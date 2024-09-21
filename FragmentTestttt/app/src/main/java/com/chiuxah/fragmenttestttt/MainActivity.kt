package com.chiuxah.fragmenttestttt

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chiuxah.fragmenttestttt.ui.theme.FragmentTesttttTheme

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
      //  val fr = supportFragmentManager.findFragmentById(R.id.)
        val b : Button = findViewById(R.id.b)
        val b2 : Button = findViewById(R.id.b2)
        b.setOnClickListener { replaceFragment(AnotherFragment()) }
        b2.setOnClickListener { replaceFragment(RightFragment()) }
        replaceFragment(RightFragment())

    }

    private fun replaceFragment(f : android.app.Fragment) {
        val fm = fragmentManager
        val trans = fm.beginTransaction()
        //trans.replace(R.id.rl,f)
        trans.commit()
        trans.addToBackStack(null)
    }
}



