
package  com.example.alarmque
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import com.example.alarmque.R

class MyBroadcastDemo:BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
       val mp=MediaPlayer.create(p0, R.raw.music)
            mp.start()
            Log.d("Hello", "AlarmRinging")
    }
}