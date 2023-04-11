package com.example.image_switch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var nameList= intArrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img7,

    )

    var index=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isw=findViewById<ImageSwitcher>(R.id.imgSwitch)
        val btn=findViewById<Button>(R.id.btnNext)

        isw.setFactory {
            val imageView=ImageView(applicationContext)
            imageView.scaleType=ImageView.ScaleType.FIT_CENTER
            imageView.setPadding(8,8,8,8)

            imageView
        }

        isw.setImageResource(nameList[index])

        val imgIn=AnimationUtils.loadAnimation(
            this,android.R.anim.slide_in_left
        )

        isw.inAnimation=imgIn

        val imgOut=AnimationUtils.loadAnimation(
            this,android.R.anim.slide_out_right
        )
        isw.outAnimation=imgOut

        btn.setOnClickListener {
            index = if (index + 1 < nameList.size) index + 1 else 0
            isw.setImageResource(nameList[index])
        }

    }
}