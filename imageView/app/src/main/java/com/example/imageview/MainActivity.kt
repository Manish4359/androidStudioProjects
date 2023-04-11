package com.example.imageview

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleImageView=findViewById<ImageView>(R.id.imageView)

        val centerCrop=findViewById<Button>(R.id.centerCrop)
        centerCrop.setOnClickListener(View.OnClickListener {
            simpleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP)
        })

        val center=findViewById<Button>(R.id.center)

        center.setOnClickListener(View.OnClickListener {
            simpleImageView.setScaleType(ImageView.ScaleType.CENTER)
        })

        val centerInside=findViewById<Button>(R.id.centerInside)

        centerInside.setOnClickListener(View.OnClickListener {
            simpleImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
        })

        val fitCenter=findViewById<Button>(R.id.fitCenter)

        fitCenter.setOnClickListener(View.OnClickListener {
            simpleImageView.setScaleType(ImageView.ScaleType.FIT_CENTER)
        })

        val fitEnd=findViewById<Button>(R.id.fitEnd)

        fitEnd.setOnClickListener(View.OnClickListener {
            simpleImageView.setScaleType(ImageView.ScaleType.FIT_END)
        })

        val fitStart=findViewById<Button>(R.id.fitStart)

        fitStart.setOnClickListener(View.OnClickListener {
            simpleImageView.setScaleType(ImageView.ScaleType.FIT_START)
        })

        val fitXY=findViewById<Button>(R.id.fitXY)

        fitXY.setOnClickListener(View.OnClickListener {
            simpleImageView.setScaleType(ImageView.ScaleType.FIT_XY)
        })

        val matrix=findViewById<Button>(R.id.matrix)

        matrix.setOnClickListener(View.OnClickListener {
            simpleImageView.setScaleType(ImageView.ScaleType.MATRIX)
        })

    }
}