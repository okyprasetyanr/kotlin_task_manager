package com.example.task_manager.features.main_menu.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task_manager.features.main_menu.domain.model.ModelProject
import com.example.task_manager.features.main_menu.data.repository.ProjectRepositoryImpl
import com.example.task_manager.features.main_menu.domain.usecase.GetProjectsUseCase

class ProjectViewModel : ViewModel() {
    private val repository = ProjectRepositoryImpl()
    private val getProjectsUseCase = GetProjectsUseCase(repository)
    private val _projects = MutableLiveData<List<ModelProject>>()
    val projects: LiveData<List<ModelProject>> = _projects

    fun loadProjects() {
        _projects.value = getProjectsUseCase()
    }
}