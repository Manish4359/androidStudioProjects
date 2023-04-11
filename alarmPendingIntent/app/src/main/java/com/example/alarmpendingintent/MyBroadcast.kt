package com.example.alarmpendingintent

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast

class MyBroadcast:BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        var mp = MediaPlayer.create(p0, R.raw.music)

        mp.start()
        Log.d("Hello","alarm is ringing")
        Toast.makeText(p0,"alarm is ringing", Toast.LENGTH_LONG).show()
    }
}