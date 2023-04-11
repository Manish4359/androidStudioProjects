package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var lastNum:Boolean=false;
    var lastDecimal:Boolean=false;
    fun onDigit(view: View) {
        lastNum=true;
        screen.append((view as Button).text)
    }
    fun onClear(view: View){
        lastDecimal=false
        lastNum=false
        screen.text=""
    }
    fun  onDecimal(view: View){

        if(!lastDecimal && lastNum){
            lastDecimal=true;
            screen.append((view as Button).text)

        }
    }



}