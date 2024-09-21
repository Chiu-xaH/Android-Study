package com.chiuxah.fragmentstest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val b : Button = findViewById(R.id.b)

        b.setOnClickListener { replaceFragment(AnotherFragment()) }

        replaceFragment(RightFragment())

                }

    private fun replaceFragment(f : android.app.Fragment) {
        val fm = fragmentManager
        val trans = fm.beginTransaction()
        trans.replace(R.id.rl,f)
        trans.commit()
    }
            }
