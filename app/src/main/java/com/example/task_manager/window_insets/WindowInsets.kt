package com.example.task_manager.window_insets

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.app.Activity
import android.view.ViewGroup

object InsetsUtil {
    fun applySystemBarInsetsToView(rootView: View?) {
        rootView?.let { view ->
            ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
                val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
                insets
            }
        }
    }

    fun applySystemBarInsets(activity: Activity) {
        val content = activity.findViewById<ViewGroup>(android.R.id.content)
        applySystemBarInsetsToView(content.getChildAt(0))
    }
}