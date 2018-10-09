package com.yuluyao.exv

import android.support.v4.view.GestureDetectorCompat
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent

abstract class OnItemClickListener : RecyclerView.SimpleOnItemTouchListener() {

  var recyclerView: RecyclerView? = null
  var detector: GestureDetectorCompat? = null

  abstract fun onItemClicked(position: Int)

  override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean {
    if (recyclerView == null || detector == null) {
      recyclerView = rv
      detector = GestureDetectorCompat(rv?.context, GestureListener())
    }
    return detector!!.onTouchEvent(e)
  }

  inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
    override fun onSingleTapUp(e: MotionEvent?): Boolean {
      e ?: return false
      val child = recyclerView?.findChildViewUnder(e.x, e.y)
      child ?: return false
      val position = recyclerView?.getChildAdapterPosition(child)
      position ?: return false
      onItemClicked(position)
      return true
    }

  }


}