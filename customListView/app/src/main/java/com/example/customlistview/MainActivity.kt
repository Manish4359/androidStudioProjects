package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView:ListView=findViewById(R.id.listView)
        var list= mutableListOf<Model>()

//        list.add(Model("Facebook","facebook description",R.drawable.facebook))
//        list.add(Model("Twitter","twitter description",R.drawable.twitter))
//        list.add(Model("Google","google description",R.drawable.google))
//        list.add(Model("Youtube","youtube description",R.drawable.youtube))
//        list.add(Model("Whatsapp","whatsapp description",R.drawable.whatsapp))
//



//        listView.adapter=MyAdapter(this,list)

    }
}