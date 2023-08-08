package com.example.shopping_cart

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var images: ArrayList<Int> = ArrayList()

        images.add(R.drawable.ic_launcher_background)
        images.add(R.drawable.ic_launcher_background)
        images.add(R.drawable.ic_launcher_background)
        images.add(R.drawable.ic_launcher_background)

        var array = arrayOf<ItemModel>(
            ItemModel("mango", "100"),
            ItemModel("mango", "100"),
            ItemModel("mango", "100"),
            ItemModel("mango", "100")
        )

        val gridview:GridView = findViewById(R.id.gridView)
        val adapter = ItemsAdapter(this@MainActivity, images, array)
        gridview.adapter = adapter
        var cartbtn = findViewById<Button>(R.id.gotocart)

        val cartList:ArrayList<CartItem> = ArrayList()

        gridview.setOnItemClickListener { adapterView, parent, position, l ->
            Toast.makeText(this@MainActivity, "clicked", Toast.LENGTH_LONG).show()
            cartList.add(CartItem(array[position].name, array[position].price.toString(), 1))
        }

        cartbtn.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra("cartItems", cartList)
            startActivity(intent)
        }
    }


}
