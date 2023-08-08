package com.example.customgridview

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MainActivity : AppCompatActivity() {

    lateinit var arrayList:ArrayList<Int>
    lateinit var gridview:GridView
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayList= ArrayList()

        arrayList.add(R.drawable.facebook)
        arrayList.add(R.drawable.google)
        arrayList.add(R.drawable.twitter)
        arrayList.add(R.drawable.youtube)

        val array= arrayOf("Facebook","Google","Twitter","Youtube")

        gridview=findViewById<GridView>(R.id.gridview)
        gridview.adapter=MyAdapter(this,arrayList,array)

        gridview.setOnItemClickListener{
            adapterView,parent,position,l ->

            Toast.makeText(this,array[position],Toast.LENGTH_LONG).show()
        }
    }
}
class MyAdapter(context: Context,arraylist:ArrayList<Int>,names:Array<String>):BaseAdapter(){

    val context=context
    val arraylist=arraylist
    val names=names
    override fun getCount(): Int {
    return arraylist.size
    }

    override fun getItem(p0: Int): Any {
       return p0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var myView = p1
        var holder: ViewHolder

        if (myView == null) {

            val inflater = (context as Activity).layoutInflater
            myView = inflater.inflate(R.layout.item, p2, false)

            holder = ViewHolder()

            holder.imageView = myView!!.findViewById<ImageView>(R.id.imageView)
            holder.textView = myView!!.findViewById<TextView>(R.id.textview)

            myView.tag = holder

        } else {
            holder = myView.tag as ViewHolder
        }

        holder.imageView!!.setImageResource(arraylist[p0])
        holder.textView!!.text= names[p0]
        return myView
    }
    class ViewHolder{
        var imageView:ImageView?=null
        var textView:TextView?=null
    }

}
