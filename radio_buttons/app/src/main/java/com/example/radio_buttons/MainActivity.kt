package com.example.radio_buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onClickedApple(view: View){
            Toast.makeText(this,"apple is your favorite fruit",Toast.LENGTH_SHORT).show()
    }

    fun onCLickedMango(view: View){
            Toast.makeText(this,"mango is your favorite fruit",Toast.LENGTH_SHORT).show()
    }

    fun onCLickedPineapple(view: View){
            Toast.makeText(this,"pineapple is your favorite fruit",Toast.LENGTH_SHORT).show()
    }

    fun onClickedOrange(view: View){
            Toast.makeText(this,"apple is your favorite fruit",Toast.LENGTH_SHORT).show()
    }
}