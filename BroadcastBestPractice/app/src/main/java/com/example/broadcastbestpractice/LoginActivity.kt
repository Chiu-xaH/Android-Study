package com.example.broadcastbestpractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val ir = prefs.getBoolean("记住密码",false)

        val accountEdit : EditText = findViewById(R.id.accountEdit)
        val passwordEdit : EditText = findViewById(R.id.passwordEdit)
        val account = accountEdit.text.toString()
        val password = passwordEdit.text.toString()
        val login : Button = findViewById(R.id.login)
        val box : CheckBox = findViewById(R.id.box)
        if (ir)  {
            val amount = prefs.getString("账号","")
            val password = prefs.getString("密码","")
            accountEdit.setText(amount)
            passwordEdit.setText(password)
            box.isChecked = true
        }
        login.setOnClickListener {
            if (account == "A" && password == "1") {
                Toast.makeText(this,"dui了",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this,"错了",Toast.LENGTH_SHORT).show()
            }
        }

    }
}