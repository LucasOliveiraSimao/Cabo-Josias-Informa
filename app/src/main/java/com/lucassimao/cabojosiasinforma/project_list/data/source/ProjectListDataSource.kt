package com.lucassimao.cabojosiasinforma.project_list.data.source

import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectDetailsDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel

interface ProjectListDataSource {
    fun fetchProjectList(): List<ProjectListDataModel>
    fun getProjectDetails(id: Int): ProjectDetailsDataModel
}