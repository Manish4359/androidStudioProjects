package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class ArcDemo(context: Context?) : View(context) {
    var paint=Paint()
    var x=100

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color=Color.BLACK
        //canvas?.drawRect(100f,100f,500f,500f,paint)
        canvas?.drawArc(100f,100f,500f,500f,x.toFloat(),30f,true,paint)
        canvas?.drawArc(100f,100f,500f,500f,x.toFloat()+120,30f,true,paint)
        canvas?.drawArc(100f,100f,500f,500f,x.toFloat()+240,30f,true,paint)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){

            MotionEvent.ACTION_DOWN->startFan()
            MotionEvent.ACTION_UP->stopFan()
        }

        return super.onTouchEvent(event)
    }
    fun startFan(){
        x+=40
        invalidate()
    }
    fun stopFan(){

    }
}