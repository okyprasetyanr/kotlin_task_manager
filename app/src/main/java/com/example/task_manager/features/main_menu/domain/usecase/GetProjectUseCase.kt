package com.example.task_manager.features.main_menu.domain.usecase

import com.example.task_manager.features.main_menu.domain.model.ModelProject
import com.example.task_manager.features.main_menu.domain.`interface`.ProjectRepository

class GetProjectsUseCase(
    private val repository: ProjectRepository
) {
    operator fun invoke(): List<ModelProject> {
        return repository.getProjects()
    }
}