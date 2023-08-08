package com.example.shopping_cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView

class CartItemsAdapter(private  var context:Context,private  var resources:Int,private var items:List<CartItem>)
    :ArrayAdapter<CartItem>(context,resources,items)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)

        val view:View=layoutInflater.inflate(resources,null)

        val name: TextView =view.findViewById(R.id.itemName)
        val price: TextView =view.findViewById(R.id.itemPrice)
        val quantity: TextView =view.findViewById(R.id.quantity)
        val incBtn:Button=view.findViewById(R.id.incQuantity)
        val decBtn:Button=view.findViewById(R.id.decQuantity)

        val item:CartItem=items[position]
        name.text=item.name
        price.text=item.price
        quantity.text= item.quantity.toString()

        incBtn.setOnClickListener {

            items[position].quantity++
            quantity.text=items[position].quantity.toString()
        }
        decBtn.setOnClickListener {

            if(items[position].quantity!=0) {
                items[position].quantity--
                quantity.text = items[position].quantity.toString()
            }
        }
        return view
    }

}

class CartItem(var name:String,var price:String,var quantity:Int)