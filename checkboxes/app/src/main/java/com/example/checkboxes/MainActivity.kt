package com.example.checkboxes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pizza=findViewById<CheckBox>(R.id.checkBox)
        var coffee=findViewById<CheckBox>(R.id.checkBox2)
        var burger=findViewById<CheckBox>(R.id.checkBox3)
        var btn=findViewById<Button>(R.id.button)


        btn.setOnClickListener{

            var totalAmount:Int=0
            var result=StringBuilder()

            result.append("Selected items")
            if(pizza.isChecked){
                result.append("\npizza 100Rs")
                totalAmount+=100
            }
            if(coffee.isChecked){
                result.append("\ncoffee 50Rs")
                totalAmount+=50
            }
            if(burger.isChecked){
                result.append("\nBurger 200Rs")
                totalAmount+=200
            }
            result.append("total amount:"+totalAmount+ " Rs")

            Toast.makeText(applicationContext,result.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}