package com.lucassimao.cabojosiasinforma.project_list.domain.repository

import com.lucassimao.cabojosiasinforma.core.callback.RepositoryCallback
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel
import com.lucassimao.cabojosiasinforma.project_list.domain.model.ProjectDomainModel

interface ProjectListRepository {
    fun fetchProjectList(callback: RepositoryCallback<List<ProjectListDataModel>>)
    fun getProjectDetails(id: Int, callback: RepositoryCallback<ProjectDomainModel>)
}