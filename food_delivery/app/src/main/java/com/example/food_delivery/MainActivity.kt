package com.example.food_delivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pizzaPrice=399
        val burgerPrice=99
        val coffeePrice=49
        var pizzaQuantity=0
        var burgerQuantity=0
        var coffeeQuantity=0

        val buyNowBtn=findViewById<Button>(R.id.buyNow) as Button
        val incPizzaBtn=findViewById<Button>(R.id.button2) as Button
        val decPizzaBtn=findViewById<Button>(R.id.button) as Button

        incPizzaBtn.setOnClickListener{
            pizzaQuantity++
        }
        decPizzaBtn.setOnClickListener{

            if(pizzaQuantity>0){
                pizzaQuantity--
            }
        }
        buyNowBtn.setOnClickListener{
            Toast.makeText(applicationContext,"your order has been placed",Toast.LENGTH_LONG).show()
        }


    }
}