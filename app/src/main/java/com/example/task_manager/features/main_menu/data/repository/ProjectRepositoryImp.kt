package com.example.task_manager.features.main_menu.data.repository

import com.example.task_manager.features.main_menu.domain.enum.EnumStatus
import com.example.task_manager.features.main_menu.domain.model.ModelProject
import com.example.task_manager.features.main_menu.domain.`interface`.ProjectRepository
import java.util.Date

class ProjectRepositoryImpl : ProjectRepository {
    override fun getProjects(): List<ModelProject> {
        return listOf(
            ModelProject(
                projectId = "PRJ001",
                projectName = "Task Manager Mobile",
                projectStatus = EnumStatus.On_Progress,
                projectStart = Date(),
                projectEnd = Date(),
                projectDeadLine = Date(),
                projectType = "Mobile App",
                projectTypeId = "TYPE001",
                projectCreatedBy = "Oky",
                projectCreatedById = "USR001",
                projectContributor = 5
            )
        )
    }
}