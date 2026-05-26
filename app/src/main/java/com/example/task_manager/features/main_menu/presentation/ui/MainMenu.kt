package com.example.task_manager.features.main_menu.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task_manager.R
import com.example.task_manager.features.detail_project.presentation.ui.DetailProject
import com.example.task_manager.features.main_menu.presentation.viewmodel.ProjectViewModel
import com.example.task_manager.features.main_menu.presentation.adapter.AdapterListProject
import com.example.task_manager.window_insets.InsetsUtil.applySystemBarInsets
import com.google.android.material.button.MaterialButton

class MainMenu : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterListProject
    private lateinit var menuproject: MaterialButton
    private lateinit var menuTask: MaterialButton
    private lateinit var menuListDone: MaterialButton
    private lateinit var menuMasterData: MaterialButton
    private val viewModel: ProjectViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        applySystemBarInsets(this)

        adapter = AdapterListProject { project ->
            val intent = Intent(this, DetailProject::class.java)
            intent.putExtra("PROJECT_ID", project.projectId)
            startActivity(intent)
        }
        menuproject = findViewById(R.id.menuProject)
        menuListDone = findViewById(R.id.menuListDone)
        menuMasterData = findViewById(R.id.menuMasterData)
        menuTask = findViewById(R.id.menuTask)

        menuproject.setOnClickListener {
            Toast.makeText(this,"Menu Project",Toast.LENGTH_SHORT).show()
        }
        menuListDone.setOnClickListener {
            Toast.makeText(this,"Menu List",Toast.LENGTH_SHORT).show()
        }
        menuMasterData.setOnClickListener {
            Toast.makeText(this,"Menu Master Data",Toast.LENGTH_SHORT).show()
        }
        menuTask.setOnClickListener {
            Toast.makeText(this,"Menu Task",Toast.LENGTH_SHORT).show()
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        viewModel.projects.observe(this) {adapter.submitList(it)}
        viewModel.loadProjects()
    }
}