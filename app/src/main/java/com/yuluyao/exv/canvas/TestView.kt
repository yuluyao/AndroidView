package com.yuluyao.exv.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TestView : View {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

  private val paint = Paint()
  private var density: Float = 0f

  init {
    density = context.resources.displayMetrics.density

    paint.color = Color.argb(0xff, 0xff, 0x00, 0x00)
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = 6 * density

  }


  override fun onDraw(canvas: Canvas?) {
    super.onDraw(canvas)
    canvas!!

    testLine(canvas)
  }

  private fun testLine(canvas: Canvas) {
    canvas.drawLine(100F, 100F, 300F, 300F, paint)
  }
}