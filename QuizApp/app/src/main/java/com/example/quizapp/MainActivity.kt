package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart=findViewById<Button>(R.id.btnStart)
        val name=findViewById<EditText>(R.id.name)

        btnStart.setOnClickListener{

            if(name.text.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }else{
                var intent= Intent(this,QuizQuestions::class.java)
                startActivity(intent)
                finish()
            }




        }
    }
}