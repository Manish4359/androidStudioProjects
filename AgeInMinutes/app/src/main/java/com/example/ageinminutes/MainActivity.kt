package com.example.ageinminutes

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var btn:Button
    lateinit var selectedDateText:TextView
lateinit var ageInMin:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn=findViewById(R.id.btnDatePicker)
        selectedDateText=findViewById(R.id.selectedDate)
        ageInMin=findViewById(R.id.ageInMin)

        btn.setOnClickListener{view->
            clickDatePicker(view)
            Toast.makeText(this,"Selecting date",Toast.LENGTH_LONG).show()
        }
    }
    fun clickDatePicker(view: View){
        val calender=Calendar.getInstance()
        val year=calender.get(Calendar.YEAR)
        val month=calender.get(Calendar.MONTH)
        val day=calender.get(Calendar.DAY_OF_MONTH)

        var dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDay ->
            Toast.makeText(this,"date picker works $selectedDay $selectedMonth $selectedYear",Toast.LENGTH_LONG).show()

            val selectedDate="$selectedDay/${if(selectedMonth<9) "0${selectedMonth+1}" else selectedMonth+1}/$selectedYear"

            selectedDateText.text = selectedDate

            val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val date=sdf.parse(selectedDate)

            val selectedDateInMinutes=date!!.time/60000

            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
            val currntDateInMinutes=currentDate!!.time/60000

            val ageInMinutes=currntDateInMinutes-selectedDateInMinutes

            ageInMin.text=ageInMinutes.toString()

        }, year,month,day)

        //limit the maxdate to be choosen
        dpd.datePicker.maxDate=Date().time
        dpd.show()
    }
}