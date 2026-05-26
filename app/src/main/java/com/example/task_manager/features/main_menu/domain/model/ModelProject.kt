package com.example.task_manager.features.main_menu.domain.model

import com.example.task_manager.features.main_menu.domain.enum.EnumStatus
import java.util.Date

class ModelProject (
    val projectId:String,
    val projectName:String,
    val projectStatus: EnumStatus,
    val projectStart:Date,
    val projectEnd:Date,
    val projectDeadLine:Date,
    val projectType:String,
    val projectTypeId:String,
    val projectCreatedBy:String,
    val projectCreatedById:String,
    val projectContributor:Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ModelProject
        if (projectContributor != other.projectContributor) return false
        if (projectId != other.projectId) return false
        if (projectName != other.projectName) return false
        if (projectStatus != other.projectStatus) return false
        if (projectStart != other.projectStart) return false
        if (projectEnd != other.projectEnd) return false
        if (projectDeadLine != other.projectDeadLine) return false
        if (projectType != other.projectType) return false
        if (projectTypeId != other.projectTypeId) return false
        if (projectCreatedBy != other.projectCreatedBy) return false
        if (projectCreatedById != other.projectCreatedById) return false

        return true
    }

    override fun hashCode(): Int {
        var result = projectContributor
        result = 31 * result + projectId.hashCode()
        result = 31 * result + projectName.hashCode()
        result = 31 * result + projectStatus.hashCode()
        result = 31 * result + projectStart.hashCode()
        result = 31 * result + projectEnd.hashCode()
        result = 31 * result + projectDeadLine.hashCode()
        result = 31 * result + projectType.hashCode()
        result = 31 * result + projectTypeId.hashCode()
        result = 31 * result + projectCreatedBy.hashCode()
        result = 31 * result + projectCreatedById.hashCode()
        return result
    }
}