package com.example.ca3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bookHotel1=findViewById<Button>(R.id.bookHotel1)
        var bookHotel2=findViewById<Button>(R.id.bookHotel2)

        bookHotel1.setOnClickListener{
            setContentView(R.layout.booked_activity)
            Toast.makeText(this,"Hotel 1 booked!!",Toast.LENGTH_SHORT).show()
        }
        bookHotel2.setOnClickListener {
            setContentView(R.layout.booked_activity)
            Toast.makeText(this,"Hotel 2 booked",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }


}