package com.example.shopping_cart

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class ItemsAdapter(context: Context, arraylist:ArrayList<Int>,array:Array<ItemModel>): BaseAdapter(){

    val context=context
    val arraylist=arraylist
    var array=array
    override fun getCount(): Int {
        return arraylist.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var myView = p1
        var holder: ViewHolder

        if (myView == null) {

            val inflater = (context as Activity).layoutInflater
            myView = inflater.inflate(R.layout.item, p2, false)

            holder = ViewHolder()

            holder.image = myView!!.findViewById<ImageView>(R.id.itemImage)
            holder.name = myView!!.findViewById<TextView>(R.id.itemName)
            holder.price = myView!!.findViewById<TextView>(R.id.itemPrice)
            holder.addBtn = myView!!.findViewById<Button>(R.id.addToCart)


            myView.tag = holder

        } else {
            holder = myView.tag as ViewHolder
        }


        holder.image!!.setImageResource(arraylist[p0])
        holder.name!!.text = array[p0].name
        holder.price!!.text=array[p0].price

        holder.addBtn!!.setOnClickListener{
        }

        return myView
    }

    class ViewHolder{
        var image:ImageView?=null
        var name:TextView?=null
        var price:TextView?=null
        var addBtn:Button?=null
    }
}

class ItemModel(var name:String,var price:String)