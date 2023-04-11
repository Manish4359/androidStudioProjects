package com.example.contextmenu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var linearLayout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById<LinearLayout>(R.id.linearlayout)
        var btn = findViewById<Button>(R.id.button)

        registerForContextMenu(btn)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu?.setHeaderTitle("Context menu header")
        menuInflater.inflate(R.menu.context_menu, menu)


    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                Toast.makeText(this@MainActivity, "item1", Toast.LENGTH_LONG).show()
                linearLayout?.setBackgroundColor(Color.RED)
                true
            }
            R.id.item2 -> {
                Toast.makeText(this@MainActivity, "item2", Toast.LENGTH_LONG).show()
                linearLayout?.setBackgroundColor(Color.GREEN)
                true
            }
            R.id.item3 -> {
                Toast.makeText(this@MainActivity, "item3", Toast.LENGTH_LONG).show()
                linearLayout?.setBackgroundColor(Color.YELLOW)
                true
            }
            R.id.item4 -> {
                Toast.makeText(this@MainActivity, "item4", Toast.LENGTH_LONG).show()
                linearLayout?.setBackgroundColor(Color.BLUE)
                true
            }
            R.id.subitem1 -> {
                Toast.makeText(this@MainActivity, "subitem1", Toast.LENGTH_LONG).show()
                linearLayout?.setBackgroundColor(Color.CYAN)
                true
            }
            R.id.subitem2 -> {
                Toast.makeText(this@MainActivity, "subitem2", Toast.LENGTH_LONG).show()
                linearLayout?.setBackgroundColor(Color.MAGENTA)
                true
            }
            R.id.subitem3 -> {
                Toast.makeText(this@MainActivity, "subitem3", Toast.LENGTH_LONG).show()
                linearLayout?.setBackgroundColor(Color.DKGRAY)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}