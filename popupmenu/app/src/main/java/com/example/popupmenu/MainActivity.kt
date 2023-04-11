package com.example.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button=findViewById<Button>(R.id.button)
        button.setOnClickListener(){
            val popupMenu= PopupMenu(this@MainActivity,button)
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                menuItem->
                Toast.makeText(this@MainActivity,"You clicked"+menuItem.title,Toast.LENGTH_SHORT).show()
                true
            }
            popupMenu.show()
        }
    }
}