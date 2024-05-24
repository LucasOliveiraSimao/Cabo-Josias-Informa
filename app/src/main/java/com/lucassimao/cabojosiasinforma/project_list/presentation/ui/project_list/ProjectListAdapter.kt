package com.lucassimao.cabojosiasinforma.project_list.presentation.ui.project_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucassimao.cabojosiasinforma.databinding.ProjectListItemListBinding
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel
import javax.inject.Inject

class ProjectListAdapter @Inject constructor() :
    RecyclerView.Adapter<ProjectListAdapterViewHolder>() {

    private val list = mutableListOf<ProjectListDataModel>()

    val getProjectList: (List<ProjectListDataModel>) -> Unit = {
        list.clear()
        list.addAll(it)
    }

    var onProjectListClick: (ProjectListDataModel) -> Unit = {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProjectListAdapterViewHolder {
        val binding = ProjectListItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProjectListAdapterViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ProjectListAdapterViewHolder, position: Int) {
        holder.bind(list[position], onProjectListClick)
    }
}

class ProjectListAdapterViewHolder(
    private val binding: ProjectListItemListBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        projectListDataModel: ProjectListDataModel,
        onProjectListClick: (ProjectListDataModel) -> Unit
    ) {

        binding.projectListTitle.text = projectListDataModel.title
        binding.root.setOnClickListener {
            onProjectListClick.invoke(projectListDataModel)
        }

    }
}
