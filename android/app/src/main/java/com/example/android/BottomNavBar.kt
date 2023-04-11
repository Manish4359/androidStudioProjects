package com.example.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavBar:AppCompatActivity() {

    lateinit var t:TextView

    @SuppressLint("MissingInflateId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.bottomnavbar)
        val nav=findViewById<BottomNavigationView>(R.id.bottomVav)
        t=findViewById<TextView>(R.id.textView6)

        nav.setOnItemSelectedListener {
            when(it.itemId){

                R.id.home ->{
                    setContent("home")
                    true
                }


                R.id.favorite ->{
                    setContent("favorites")
                    true
                }

                R.id.settings ->{
                    setContent("settings")
                    true
                }
                else ->false
            }
        }

    }
    fun setContent(s:String){
        setTitle(s)
        t.setText(s)
    }

}