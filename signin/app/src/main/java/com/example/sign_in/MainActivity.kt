package com.example.sign_in

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var signInBtn=findViewById<Button>(R.id.button) as Button
        signInBtn.setOnClickListener { View ->
            println("signed in successfully")
        }

    }
}