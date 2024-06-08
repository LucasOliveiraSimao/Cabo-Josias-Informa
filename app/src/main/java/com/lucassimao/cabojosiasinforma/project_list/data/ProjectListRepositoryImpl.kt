package com.lucassimao.cabojosiasinforma.project_list.data

import com.google.firebase.database.DatabaseError
import com.lucassimao.cabojosiasinforma.core.callback.RepositoryCallback
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.source.ProjectListDataSource
import com.lucassimao.cabojosiasinforma.project_list.data.source.remote.callback.ProjectCallback
import com.lucassimao.cabojosiasinforma.project_list.data.source.remote.callback.ProjectListCallback
import com.lucassimao.cabojosiasinforma.project_list.domain.mapper.toDomainModel
import com.lucassimao.cabojosiasinforma.project_list.domain.model.ProjectDomainModel
import com.lucassimao.cabojosiasinforma.project_list.domain.repository.ProjectListRepository
import javax.inject.Inject

class ProjectListRepositoryImpl @Inject constructor(
    private val projectListDataSource: ProjectListDataSource
) : ProjectListRepository {
    override fun fetchProjectList(callback: RepositoryCallback<List<ProjectListDataModel>>) {
        projectListDataSource.fetchProjectList(object : ProjectListCallback {
            override fun onSuccess(projectList: List<ProjectListDataModel>) {
                callback.onSuccess(projectList)
            }

            override fun onError(error: DatabaseError) {
                callback.onError(error.toException())
            }

        })
    }


    override fun getProjectDetails(id: Int, callback: RepositoryCallback<ProjectDomainModel>) {
        return projectListDataSource.getProjectDetails(id, object : ProjectCallback {
            override fun onSuccess(project: ProjectDataModel) {
                callback.onSuccess(project.toDomainModel())
            }

            override fun onError(error: DatabaseError) {
                callback.onError(error.toException())
            }

        })
    }
}