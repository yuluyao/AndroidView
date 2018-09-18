package com.yuluyao.exv.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class ClockView : View {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

  private val paint = Paint()
  private val path = Path()

  init {
    paint.isAntiAlias = true
    paint.color = Color.BLACK
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = 2f

    paint.textSize = 45f

  }

  private fun applyAttrs(context: Context, attrs: AttributeSet) {

  }

  private var mWidth = 0f
  private var mHeight = 0f
  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    mWidth = w.toFloat()
    mHeight = h.toFloat()
  }


  override fun onDraw(canvas: Canvas?) {
    super.onDraw(canvas)
    canvas!!
    drawClock(canvas)
  }

  private fun drawClock(canvas: Canvas) {
    canvas.translate(mWidth / 2, mHeight / 2)
    canvas.drawCircle(0f, 0f, 400f, paint)
//    canvas.drawCircle(0f, 0f, 380f, paint)
//    canvas.drawCircle(0f, 0f, 390f, paint)

//    for (i in 0 until 360 step 10) {
//      canvas.rotate(i.toFloat())
//      canvas.drawLine(380f, 0f, 400f, 0f, paint)
//    }
    path.addCircle(mWidth / 2, mHeight / 2, 420f, Path.Direction.CW)

    canvas.save()
    canvas.rotate(-90f)
    var degrees = 0f
    val step = 6f
    while (degrees < 360) {
      degrees += step
      canvas.rotate(step)
      if (degrees % 30f == 0f) {
        canvas.drawLine(380f, 0f, 400f, 0f, paint)
//        canvas.drawText("${(degrees / 30).toInt()}", 420f, 0f, paint)
        canvas.drawTextOnPath("helloworld11",path,0f,0f,paint)
      } else {
        canvas.drawLine(390f, 0f, 400f, 0f, paint)
      }
    }
    canvas.restore()


  }
}