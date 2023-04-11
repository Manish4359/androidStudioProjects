package com.example.customview;

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.io.path.Path

class CvDemo(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val paint=Paint(Paint.ANTI_ALIAS_FLAG)
    val faceColor= Color.CYAN
    val borderColor=Color.GREEN
    val borderSize=4.0f
    val size=320
    val mouthPath= Path()

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)
        drawFace(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    fun drawFace(canvas: Canvas?){

        paint.color=faceColor
        paint.style=Paint.Style.FILL
        val radius=size/2f
        canvas?.drawCircle(size/2f,size/2f,radius,paint)
        paint.color=borderColor
        paint.style=Paint.Style.STROKE
        paint.strokeWidth=borderSize
        canvas?.drawCircle(size/2f,size/2f,radius-borderSize,paint)
    }

    fun drawEyes(canvas: Canvas?){
        paint.color=Color.BLACK
        paint.style=Paint.Style.FILL
        val leftEye=RectF(size*0.32f,size*0.3f,size*0.43f,size*0.5f)
        canvas?.drawOval(leftEye,paint)
        val rightEye=RectF(size*0.57f,size*0.3f,size*0.68f,size*0.5f)
        canvas?.drawOval(rightEye,paint)
    }

    fun drawMouth(canvas: Canvas?){

        paint.color=Color.BLACK
        paint.style=Paint.Style.FILL
        mouthPath.moveTo(size*0.22f,size*0.7f)
        mouthPath.quadTo(size*0.5f,size*0.5f,size*0.78f,size*0.7f)
        mouthPath.quadTo(size*0.5f,size*0.6f,size*0.22f,size*0.7f)
        canvas?.drawPath(mouthPath,paint)

    }

}
