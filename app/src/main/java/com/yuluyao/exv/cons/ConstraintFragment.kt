package com.yuluyao.exv.cons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import com.yuluyao.exv.R
import kotlinx.android.synthetic.main.fragment_constraint.*

class ConstraintFragment : Fragment() {


  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_constraint, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    tv_1.setOnClickListener {}


  }

  companion object {
    fun newInstance(): ConstraintFragment {
      val args = Bundle()
      val fragment = ConstraintFragment()
      fragment.arguments = args
      return fragment
    }
  }
}
