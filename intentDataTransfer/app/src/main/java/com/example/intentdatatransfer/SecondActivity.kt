package com.example.intentdatatransfer

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val edittext=findViewById<EditText>(R.id.editText2)
        val btn=findViewById<Button>(R.id.btn2)

        val layout=findViewById<LinearLayout>(R.id.layout2)
        val bundle:Bundle?=intent.extras
        val text=bundle?.get("text").toString()

        val textview= TextView(this)

        textview.layoutParams= LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        if(text!=""){
            textview.text=text
            layout.addView(textview)
        }


        btn.setOnClickListener {
            val value=edittext.text.toString()

            intent= Intent(this,MainActivity::class.java)
            intent.putExtra("text",value)
            startActivity(intent)
        }
    }
}