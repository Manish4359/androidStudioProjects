package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),backPressCall {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressCall(msg:String) {
        var fr=supportFragmentManager.findFragmentById(R.id.fragment2) as StaticFragmentTwo
        fr.onFragmentInteraction(msg)
    }
}