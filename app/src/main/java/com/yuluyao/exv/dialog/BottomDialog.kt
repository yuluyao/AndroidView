package com.yuluyao.exv.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.*
import com.yuluyao.exv.R

/**
 * 底部透明的 Dialog
 */
abstract class BaseBottomDialog : DialogFragment() {

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    initWindowParam()
  }

  private fun initWindowParam() {
    val window = dialog.window
    // 背景图设为透明,同时去掉了 padding 属性
    window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    // 不使下层视图变暗
    window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    // 视图位于底部
    window.setGravity(Gravity.BOTTOM)

    val lp = window.attributes
    // 宽度占满
    lp.width = WindowManager.LayoutParams.MATCH_PARENT
    window.attributes = lp
  }
}

class BottomTransformDialog : BaseBottomDialog() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.dialog_bottom, container, false)
  }
}
