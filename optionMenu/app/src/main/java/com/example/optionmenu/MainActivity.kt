package com.example.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.about -> Toast.makeText(this,"About selected",Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this,"Settings selected",Toast.LENGTH_SHORT).show()
            R.id.logout -> Toast.makeText(this,"Logout selected",Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}