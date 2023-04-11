package com.example.radio_btn_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var radioGroup=findViewById<RadioGroup>(R.id.radioGroup)
        var btn=findViewById<Button>(R.id.btnDisplay)

        btn.setOnClickListener{

            val intSelectBtn:Int=radioGroup.checkedRadioButtonId
            var radioBtn=findViewById<RadioButton>(intSelectBtn)
            Toast.makeText(applicationContext,radioBtn.text,Toast.LENGTH_SHORT).show()
        }
    }
}