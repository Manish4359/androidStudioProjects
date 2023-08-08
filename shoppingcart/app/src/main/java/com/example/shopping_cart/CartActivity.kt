package com.example.shopping_cart

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        var listView: ListView =findViewById(R.id.listView)
        var list= ArrayList<CartItem>()

        list.add(CartItem("mango","100",1))

        list.addAll((intent.getParcelableArrayListExtra("cartItems")  ?: emptyList()))
        listView.adapter=CartItemsAdapter(this,R.layout.cart_item,list)

        listView.setOnItemClickListener{
                parent: AdapterView<*>, view: View, position:Int, id:Long->
            Toast.makeText(applicationContext,"clicked", Toast.LENGTH_LONG).show()
        }
    }
}