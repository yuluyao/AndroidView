package com.yuluyao.exv.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CaView : View {

  companion object {
    private const val TAG = "CaView"
  }

  // 在java中创建时被调用
  constructor(context: Context) : super(context)

  // 在xml中创建时被调用
  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    applyAttrs(context,attrs)
  }

  private val mPaint: Paint = Paint()

  init {
    mPaint.color = Color.RED
    mPaint.style = Paint.Style.FILL
    mPaint.strokeWidth = 1f
    mPaint.isAntiAlias = true
    mPaint.textSize=36f
  }

  private var density = 3f
  private var mWidth = 0
  private var mHeight = 0
  private fun applyAttrs(context: Context, attrs: AttributeSet) {
    val displayMetrics = context.resources.displayMetrics
    density = displayMetrics.density

  }


  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    mWidth=w
    mHeight=h
  }

  override fun onDraw(canvas: Canvas?) {
    super.onDraw(canvas)
    canvas!!
//    drawBackground(canvas)
    drawCoordinates(canvas)
//    canvas.drawLine(0f, 0f, 100f, 100f, mPaint)

  }

  /**
   * 画背景
   */
  private fun drawBackground(canvas: Canvas) {
    canvas.drawColor(Color.CYAN)
  }


  /**
   * 画坐标系
   */
  private fun drawCoordinates(canvas: Canvas) {
    // 原点
    canvas.drawText("0",mWidth/2f+20,mHeight/2f+40,mPaint)

    // x轴
    canvas.drawLine(0f, mHeight / 2f, mWidth.toFloat(), mHeight / 2f,mPaint)
    canvas.save()
    // translate to right middle
    canvas.translate(mWidth.toFloat(),mHeight/2f)

    // 画箭头
    canvas.save()
    canvas.rotate(45f)
    canvas.drawLine(0f,0f,-20f,0f,mPaint)
    canvas.rotate(-90f)
    canvas.drawLine(0f,0f,-20f,0f,mPaint)
    canvas.restore()

    canvas.drawText("x",-30f,40f,mPaint)
    canvas.restore()


    // y轴
    canvas.drawLine(mWidth / 2f, 0f, mWidth / 2f, mHeight.toFloat(),mPaint)

    canvas.save()
    canvas.translate(mWidth/2f,mHeight.toFloat())

    // 画箭头
    canvas.save()
    canvas.rotate(45f)
    canvas.drawLine(0f,0f,0f,-20f,mPaint)
    canvas.rotate(-90f)
    canvas.drawLine(0f,0f,0f,-20f,mPaint)
    canvas.restore()

    canvas.drawText("y",20f,-20f,mPaint)
    canvas.restore()



  }

}