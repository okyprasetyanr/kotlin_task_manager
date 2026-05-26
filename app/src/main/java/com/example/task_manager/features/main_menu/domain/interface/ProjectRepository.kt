package com.example.task_manager.features.main_menu.domain.`interface`

import com.example.task_manager.features.main_menu.domain.model.ModelProject

interface ProjectRepository {
    fun getProjects(): List<ModelProject>
}
