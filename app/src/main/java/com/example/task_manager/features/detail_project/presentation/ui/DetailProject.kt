package com.example.task_manager.features.detail_project.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task_manager.R
import com.example.task_manager.window_insets.InsetsUtil
import com.example.task_manager.window_insets.InsetsUtil.applySystemBarInsets

class DetailProject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_project)
        applySystemBarInsets(this)

    }
}