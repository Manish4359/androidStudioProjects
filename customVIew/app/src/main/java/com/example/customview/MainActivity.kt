package com.example.customview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var d=TouchDemo(this)
        super.onCreate(savedInstanceState)
        setContentView(d)
    }
}