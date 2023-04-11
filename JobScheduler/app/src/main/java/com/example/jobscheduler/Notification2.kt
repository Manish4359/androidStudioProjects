package com.example.jobscheduler

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Notification2 : AppCompatActivity() {
    lateinit  var notificationManeger: NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification2)
        var tv=findViewById<TextView>(R.id.textView)
        tv.text="My text view"
        var i=Notification1()
        notificationManeger=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManeger.cancel(i.notificationId)
    }
}