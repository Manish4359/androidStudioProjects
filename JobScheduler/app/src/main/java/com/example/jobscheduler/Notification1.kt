package com.example.jobscheduler

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.getSystemService

class Notification1 : AppCompatActivity() {
    lateinit  var notificationManeger:NotificationManager
    lateinit var notificationChannel:NotificationChannel
    lateinit var builder:Notification.Builder

    val notificationId=123
    val channelId="My Channel"
    val title="My Notification"
    val description="My Description test"
    lateinit var pendingIntent: PendingIntent
    lateinit var btn:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification1)
        btn=findViewById(R.id.btn)
        btn.setOnClickListener {
            notificationManeger=getSystemService(Context.NOTIFICATION_SERVICE)  as NotificationManager
            var i=Intent(this,NotificationViewExample::class.java)
            pendingIntent=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_IMMUTABLE)
            createChannel()
            notificationManeger.notify(notificationId,builder.build())

        }
    }
    fun createChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            notificationChannel= NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableVibration(true)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor=Color.YELLOW
            notificationManeger.createNotificationChannel(notificationChannel)

            builder=Notification.Builder(this,channelId)
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setContentText(description)
                .setContentIntent(pendingIntent).setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_baseline_notifications_none_24))
                .setAutoCancel(true)
        }
        else{
            builder=Notification.Builder(this,channelId)
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setContentText(description)
                .setContentIntent(pendingIntent).setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_baseline_notifications_none_24))
                .setAutoCancel(true)
        }
    }
}