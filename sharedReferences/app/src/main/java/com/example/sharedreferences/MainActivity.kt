package com.example.sharedreferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var name:TextView
    lateinit var email:TextView
    lateinit var phone:TextView
    lateinit var dob:TextView
    lateinit var password:TextView

    lateinit var saveBtn:Button
    lateinit var sharedPreferences:SharedPreferences

    val Name="nameKey"
    val Email="emailKey"
    val Phone="phoneKey"
    val Dob="DobKey"
    val Password="phoneKey"
    val myFile="myPreFile"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name=findViewById(R.id.name)
        email=findViewById(R.id.email)
        saveBtn=findViewById(R.id.saveBtn)
        phone=findViewById(R.id.phone)
        dob=findViewById(R.id.dob)
        password=findViewById(R.id.password)
    }

    fun save(v:View){

        val n=name.text.toString()
        val e=email.text.toString()
        val ph=phone.text.toString()
        val db=dob.text.toString()
        val pass=password.text.toString()

        sharedPreferences=getSharedPreferences(myFile,Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        editor.putString(Name,n)
        editor.putString(Email,e)
        editor.putString(Phone,ph)
        editor.putString(Dob,db)
        editor.putString(Password,pass)
        editor.apply()
    }


    fun get(v:View){
        sharedPreferences=getSharedPreferences(myFile,Context.MODE_PRIVATE)
        name.text=sharedPreferences.getString(Name,"")
        email.text=sharedPreferences.getString(Email,"")
        phone.text=sharedPreferences.getString(Phone,"")
        dob.text=sharedPreferences.getString(Dob,"")
        password.text=sharedPreferences.getString(Password,"")
    }

    fun clear(c:View){
        name.text = ""
        email.text=""
        phone.text=""
        dob.text=""
        password.text=""
    }

    fun getDate(v:View){
        val datePicker=DatePicker(this)
        val layourParams=LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        var linear=findViewById<LinearLayout>(R.id.ll)
        linear.addView(datePicker,layourParams)


        var calender=Calendar.getInstance()
        datePicker.init(calender.get(Calendar.YEAR),calender.get(Calendar.MONTH),calender.get(Calendar.DAY_OF_MONTH)
        ){ view, year, month, day ->
            val month = month + 1
            dob.text = "$day/$month/$year"
        }
    }
}