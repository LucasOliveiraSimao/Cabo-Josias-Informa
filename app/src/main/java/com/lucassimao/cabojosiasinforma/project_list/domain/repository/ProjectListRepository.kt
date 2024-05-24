package com.lucassimao.cabojosiasinforma.project_list.domain.repository

import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectDetailsDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel

interface ProjectListRepository {
    fun fetchProjectList(): List<ProjectListDataModel>
    fun getProjectDetails(id: Int): ProjectDetailsDataModel
}