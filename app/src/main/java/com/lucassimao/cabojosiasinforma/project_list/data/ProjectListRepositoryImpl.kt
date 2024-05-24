package com.lucassimao.cabojosiasinforma.project_list.data

import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectDetailsDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.source.ProjectListDataSource
import com.lucassimao.cabojosiasinforma.project_list.domain.repository.ProjectListRepository
import javax.inject.Inject

class ProjectListRepositoryImpl @Inject constructor(
    private val projectListDataSource: ProjectListDataSource
) : ProjectListRepository {
    override fun fetchProjectList(): List<ProjectListDataModel> {
        return projectListDataSource.fetchProjectList()
    }

    override fun getProjectDetails(id: Int): ProjectDetailsDataModel {
        return projectListDataSource.getProjectDetails(id)
    }
}