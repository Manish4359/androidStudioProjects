package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ColorFragment : AppCompatActivity(),ColorInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_fragment)
    }

    override fun newColor(color: Int) {
        var fr=supportFragmentManager.findFragmentByTag("frag2") as Color2
        fr.updateColor(color)
    }

}