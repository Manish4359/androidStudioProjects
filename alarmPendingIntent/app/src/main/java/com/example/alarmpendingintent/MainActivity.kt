package com.example.alarmpendingintent

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.content.getSystemService
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var timePicker:TimePicker
    lateinit var setAlarm:Button
    lateinit var cancelAlarm:Button
    lateinit var alarmManager:AlarmManager
    lateinit var pendingIntent: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timePicker=findViewById(R.id.timepicker)
        setAlarm=findViewById(R.id.setalarm)
        cancelAlarm=findViewById(R.id.cancelalarm)

        setAlarm.setOnClickListener {
            val calender=Calendar.getInstance()
            if(Build.VERSION.SDK_INT>=23){
                calender.set(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH,timePicker.hour,timePicker.minute,0)
            }else{
                calender.set(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH,timePicker.currentHour,timePicker.currentMinute,0)
            }
            setAlarm(calender.timeInMillis)
        }

    }
    fun setAlarm(timeInMIllis:Long){

        alarmManager=getSystemService(ALARM_SERVICE) as AlarmManager
        val intent=Intent(this,MyAlarm::class.java)
        pendingIntent=PendingIntent.getBroadcast(this,0,intent, PendingIntent.FLAG_IMMUTABLE)
        alarmManager.set(AlarmManager.RTC,timeInMIllis,pendingIntent)

        Toast.makeText(this,"alarm is set",Toast.LENGTH_LONG).show()

    }

class MyAlarm:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {

        var mp = MediaPlayer.create(context, R.raw.music)

        mp.start()
        Toast.makeText(context,"alarm is ringing",Toast.LENGTH_LONG).show()
    }
}
}