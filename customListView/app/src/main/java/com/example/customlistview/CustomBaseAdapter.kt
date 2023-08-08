package com.example.customlistview

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity


class CustomBaseAdapter : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter:MyBaseAdapter
    private var arrayList:ArrayList<MyData> = ArrayList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baseadapter)


        listView=findViewById<ListView>(R.id.listView)

        arrayList.add(MyData(1,"Akash","7851234612"))
        arrayList.add(MyData(2,"Pankaj","9564321587"))
        arrayList.add(MyData(3,"Manish","9874545454"))

        adapter=MyBaseAdapter(this,arrayList)
        listView.adapter=adapter
    }
}


class MyBaseAdapter(private  val context: Context,private  val arrayList:ArrayList<MyData>)
    : BaseAdapter(){
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView=convertView
        convertView=LayoutInflater.from(context).inflate(R.layout.base_listview_item,parent,false)

        var serialNumber=convertView.findViewById<TextView>(R.id.serialNumber)
        var name=convertView.findViewById<TextView>(R.id.name)
        var phoneNumber=convertView.findViewById<TextView>(R.id.phoneNumber)
        var button=convertView.findViewById<Button>(R.id.btn)

        serialNumber.text=" "+arrayList[position].serialNumber
        name.text=" "+arrayList[position].name
        phoneNumber.text=" "+arrayList[position].phoneNumber

        button.setOnClickListener {

            Toast.makeText(context, "deleting... " + name.text, Toast.LENGTH_LONG).show()
            arrayList.removeAt(position)
            notifyDataSetChanged()

        }
        return convertView as View

    }

}

 class MyData(var serialNumber:Int,var name:String,var phoneNumber:String)