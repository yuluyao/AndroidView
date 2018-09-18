package com.capsule.exview.dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * 底部透明的 Dialog
 */
public abstract class BaseBottomDialog extends DialogFragment {

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    initWindowParam();
  }

  private void initWindowParam() {
    Window window = getDialog().getWindow();
    assert window != null;
    // 背景图设为透明,同时去掉了 padding 属性
    window.setBackgroundDrawable(new ColorDrawable(0x00000000));
    // 不使下层视图变暗
    window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    // 视图位于底部
    window.setGravity(Gravity.BOTTOM);

    WindowManager.LayoutParams lp = window.getAttributes();
    // 宽度占满
    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
    window.setAttributes(lp);
  }
}
