package com.yuluyao.exv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

//    iv.setImageResource(R.drawable.meitu_test_1)

//    recyclerView.layoutManager = LinearLayoutManager(this)
//    getSystemService(Context.POWER_SERVICE)


//    if (img.drawable is Animatable) {
//      val drawable = img.drawable as Animatable
//      drawable.start()
//    }

//    val gestureDetector = object : GestureDetector.SimpleOnGestureListener() {
////      override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
////        e!!
////        val childView = recyclerView.findChildViewUnder(e.x, e.y) ?: return false
////        val r = Rect()
////        childView.getGlobalVisibleRect(r)
////        val region = Region(r)
////        if (region.contains(e.x.toInt(), e.y.toInt())) {
////          Toast.makeText(this@MainActivity,"click item",Toast.LENGTH_SHORT).show()
////        }
////        return true
////      }
//
//      override fun onSingleTapUp(e: MotionEvent?): Boolean {
//        e!!
//        val childView = recyclerView.findChildViewUnder(e.x, e.y) ?: return false
//        val r = Rect()
//        childView.getGlobalVisibleRect(r)
//        val region = Region(r)
//        if (region.contains(e.rawX.toInt(), e.rawY.toInt())) {
//          Toast.makeText(this@MainActivity, "click item", Toast.LENGTH_SHORT).show()
//        }
//        return true
//      }
//    }
//
//    recyclerView.addOnItemTouchListener(object : RecyclerView.SimpleOnItemTouchListener() {
//      val detector = GestureDetector(this@MainActivity, gestureDetector)
//      override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
//        detector.onTouchEvent(e)
//      }
//
//      override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean {
//        return detector.onTouchEvent(e)
//      }
//
//    })


//    val adapter = Adapter()
//    adapter.menus = arrayListOf(
//      MenuItem("canvas"),
//      MenuItem("paint")
//    )
//    recyclerView.adapter = adapter
//
//    recyclerView.addOnItemTouchListener(object : OnItemClickListener() {
//      override fun onItemClicked(position: Int) {
//        Toast.makeText(this@MainActivity, "click ${adapter.menus[position].title}",
//          Toast.LENGTH_SHORT).show()
//      }
//    })



  }


  inner class Adapter : RecyclerView.Adapter<Holder>() {

    var menus = arrayListOf<MenuItem>()


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Holder {
      return Holder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1,
        parent, false))
    }

    override fun getItemCount() = menus.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
      holder.title.text = menus[position].title
    }

  }

  inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById<TextView>(android.R.id.text1)

  }

  inner class MenuItem(val title: String)


}



