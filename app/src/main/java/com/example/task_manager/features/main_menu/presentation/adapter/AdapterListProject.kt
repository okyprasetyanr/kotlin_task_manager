package com.example.task_manager.features.main_menu.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task_manager.R
import com.example.task_manager.features.main_menu.domain.model.ModelProject
import com.example.task_manager.helper.Helper

class AdapterListProject(
    private val onClick: (ModelProject) -> Unit
) : ListAdapter<ModelProject, AdapterListProject.ViewHolder>(DiffCallback()) {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val projectName: TextView =
            itemView.findViewById(R.id.projectName)
        val startedDate: TextView =
            itemView.findViewById(R.id.startedDate)
        val endDate: TextView =
            itemView.findViewById(R.id.endDate)
        val deadLineDate: TextView =
            itemView.findViewById(R.id.deadLineDate)
        val contributor: TextView =
            itemView.findViewById(R.id.contributor)
        val createdBy: TextView =
            itemView.findViewById(R.id.createdBy)
        val accountPicture: ImageView =
            itemView.findViewById(R.id.accountPicture)
        val statusProject: TextView =
            itemView.findViewById(R.id.statusProject)
        val projectType: TextView =
            itemView.findViewById(R.id.projectType)
        val projectLayout: CardView =
            itemView.findViewById(R.id.projectLayout)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.adapter_list_project,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val data = getItem(position)
        holder.projectName.text = data.projectName
        holder.projectType.text = data.projectType
        holder.statusProject.text = data.projectStatus.name
        holder.contributor.text = data.projectContributor.toString()
        holder.createdBy.text = data.projectCreatedBy
        holder.startedDate.text = Helper.convertDate(data.projectStart)
        holder.endDate.text = Helper.convertDate(data.projectEnd)
        holder.deadLineDate.text = Helper.convertDate(data.projectDeadLine)
        holder.projectLayout.setOnClickListener {
            onClick(data)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ModelProject>() {
        override fun areItemsTheSame(
            oldItem: ModelProject,
            newItem: ModelProject
        ): Boolean {
            return oldItem.projectId == newItem.projectId
        }

        override fun areContentsTheSame(
            oldItem: ModelProject,
            newItem: ModelProject
        ): Boolean {
            return oldItem == newItem
        }
    }
}