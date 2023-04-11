package com.example.dynamicview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    private var parentLinearLayout: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        parentLinearLayout = findViewById(R.id.parent_layout)
    }

    fun onDelete(view: View) {
        parentLinearLayout!!.removeView(view.parent as View)
    }
    fun save(view: View){
        val edittext=view.findViewById<EditText>(R.id.number_edit_text)

    }
    fun onAddField(view: View) {

        val rowView: View = layoutInflater.inflate(R.layout.field, null)
        parentLinearLayout!!.addView(rowView, parentLinearLayout!!.childCount - 1)
    }
}