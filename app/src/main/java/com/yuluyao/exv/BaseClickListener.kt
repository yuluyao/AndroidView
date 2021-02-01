package com.yuluyao.exv

import androidx.core.view.GestureDetectorCompat
import androidx.recyclerview.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent

abstract class BaseClickListener : RecyclerView.SimpleOnItemTouchListener() {

  protected abstract val gestureListener: GestureDetector.SimpleOnGestureListener
  protected var recyclerView: RecyclerView? = null
  private var detector: GestureDetectorCompat? = null

  override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
    if (recyclerView == null || detector == null) {
      recyclerView = rv
      detector = GestureDetectorCompat(rv.context, gestureListener)
    }
    return detector!!.onTouchEvent(e)
  }


}