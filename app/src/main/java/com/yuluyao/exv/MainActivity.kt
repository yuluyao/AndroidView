package com.yuluyao.exv

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yuluyao.exv.canvas.CanvasEx

class MainActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

//    btn.setOnClickListener {
//      val dialog = BottomTransformDialog()
//      dialog.show(supportFragmentManager, "bottom")
//    }

    val fragment = CanvasEx()
    supportFragmentManager
      .beginTransaction()
      .add(R.id.fragment_container, fragment, "tag")
      .commit()


  }


}
