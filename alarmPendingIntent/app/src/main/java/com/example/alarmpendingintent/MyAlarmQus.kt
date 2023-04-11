package com.example.alarmpendingintent

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.getSystemService

class MyAlarmQus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_alarm_qus)

        var start=findViewById<Button>(R.id.start)
        var stop=findViewById<Button>(R.id.stop)
        var repeat=findViewById<Button>(R.id.repeatalarm)
        var et=findViewById<TextView>(R.id.edittext)
        val I= Intent(this,MyBroadcast::class.java)

        var alarmManager:AlarmManager
        var pi=PendingIntent.getBroadcast(this,0,I,PendingIntent.FLAG_UPDATE_CURRENT)

        start.setOnClickListener {
            var e=et.text.toString().toInt()
            alarmManager=getSystemService(Context.ALARM_SERVICE)  as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+e*1000,pi)
            Log.d("Hello","alarm is ringing")
            Toast.makeText(this,"Alarm is set",Toast.LENGTH_LONG).show()
        }

        repeat.setOnClickListener {
            var e=et.text.toString().toInt()
            alarmManager=getSystemService(Context.ALARM_SERVICE)  as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+e*1000,5000,pi)
            Log.d("Hello","alarm is repeating")
            Toast.makeText(this,"Repeat alarm is set",Toast.LENGTH_LONG).show()
        }

    }
}