package com.example.practical

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn= findViewById<Button>(R.id.btn)
        btn.setOnClickListener {

            val dialog=AlertDialog.Builder(this)
            dialog.setTitle("Do you want to continue")
            val alertDialog = dialog.create()

            alertDialog.show()
        }
    }
}