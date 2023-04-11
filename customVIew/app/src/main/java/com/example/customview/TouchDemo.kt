package com.example.customview

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration

class TouchDemo(context: Context?) : View(context) {

    private val STROKE_WIDTH=12f
    private var path= Path()
    private var drawColor= Color.CYAN
    private var bg=Color.BLACK
    private lateinit var extraCanvas:Canvas
    private lateinit var extraBitmap:Bitmap
    private lateinit var frame:Rect

    private val paint= Paint().apply {
        color=drawColor
        isAntiAlias=true
        style=Paint.Style.STROKE
        strokeWidth=STROKE_WIDTH

    }
    private val touchTolerance=ViewConfiguration.get(context!!).scaledTouchSlop
    private var currX=0f
    private  var currY=0f
    private  var motionTouchEventX=0f
    private  var motionTouchEventY=0f
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        extraBitmap=Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
        extraCanvas= Canvas(extraBitmap)
        extraCanvas.drawColor(bg)
        val inset=40
        frame=Rect(inset,inset,width-inset,height-inset)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas!!.drawBitmap(extraBitmap,0f,0f,null)
        extraCanvas.drawRect(frame,paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        motionTouchEventX=event!!.x
        motionTouchEventY=event!!.y
        when(event.action){
            MotionEvent.ACTION_DOWN->touchStart()
            MotionEvent.ACTION_MOVE->touchMove()
            MotionEvent.ACTION_UP->touchUp()

        }
        return super.onTouchEvent(event)
    }
    private fun touchStart(){
        path.reset()
        path.moveTo(motionTouchEventX,motionTouchEventY)
        currX=motionTouchEventX
        currY=motionTouchEventY
    }
    private  fun touchMove(){
        val dx=Math.abs(motionTouchEventX-currX)
        val dy=Math.abs(motionTouchEventY-currY)
        if(dy>=touchTolerance || dy>=touchTolerance){
            path.quadTo(
                currX,
                currY,
                (motionTouchEventX+currX)/2,
                (motionTouchEventY+currY)/2
            )
            currX=motionTouchEventX
            currY=motionTouchEventY
            extraCanvas.drawPath(path,paint)
        }
        invalidate()
    }
    private fun touchUp(){
        path.reset()
    }


}