package com.example.jobscheduler

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NotificationViewExample : AppCompatActivity() {
    lateinit var notificationManager:NotificationManager
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_manager_example)
        var txtView = findViewById<TextView>(R.id.tv)
        var inp = NotificationManagerExample()
        txtView.text="Your Notification"
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        notificationManager.cancel(inp.notificationId)

    }
}