package com.example.dynamic_textview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bookMovie1=findViewById<Button>(R.id.bookMovie1)

        bookMovie1.setOnClickListener{
           var snackbar= Snackbar.make(it,"Movie Booked!!",Snackbar.LENGTH_LONG)

            snackbar.show()
        }

        var bookMovie2=findViewById<Button>(R.id.bookMovie2)

        bookMovie2.setOnClickListener{
            Snackbar.make(it,"Movie Booked!!",Snackbar.LENGTH_LONG).show()
        }
    }
}