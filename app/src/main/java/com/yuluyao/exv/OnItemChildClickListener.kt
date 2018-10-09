package com.yuluyao.exv

import android.graphics.Rect
import android.graphics.Region
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

abstract class OnItemChildClickListener : BaseClickListener() {

  abstract fun onChildClicked(position: Int, viewId: Int)
  abstract val listenedChildrenIds: IntArray

  override val gestureListener: GestureDetector.SimpleOnGestureListener
    get() = Listener()

  inner class Listener : GestureDetector.SimpleOnGestureListener() {
    override fun onSingleTapUp(e: MotionEvent?): Boolean {
      e ?: return false
      val child = recyclerView?.findChildViewUnder(e.x, e.y) as ViewGroup?
      child ?: return false

      var finalChild: View? = null
      for (i in 0 until child.childCount) {
        val childAti = child.getChildAt(i)
        if (!listenedChildrenIds.contains(childAti.id)) continue
        val r = Rect()
        childAti.getGlobalVisibleRect(r)
        val region = Region(r)
        if (region.contains(e.rawX.toInt(), e.rawY.toInt())) {
          finalChild = childAti
        }
      }
      finalChild?:return false

      val position = recyclerView?.getChildAdapterPosition(child)
      position ?: return false
      onChildClicked(position, finalChild.id)
      return true
    }
  }
}