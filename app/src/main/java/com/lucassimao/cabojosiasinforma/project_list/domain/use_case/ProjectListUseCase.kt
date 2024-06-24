package com.lucassimao.cabojosiasinforma.project_list.domain.use_case

import com.lucassimao.cabojosiasinforma.core.callback.RepositoryCallback
import com.lucassimao.cabojosiasinforma.core.callback.UseCaseCallback
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel
import com.lucassimao.cabojosiasinforma.project_list.domain.repository.ProjectListRepository
import javax.inject.Inject

class ProjectListUseCase @Inject constructor(
    private val projectListRepository: ProjectListRepository
) {
    fun fetchProjectList(callback: UseCaseCallback<List<ProjectListDataModel>>) {
        projectListRepository.fetchProjectList(object :
            RepositoryCallback<List<ProjectListDataModel>> {
            override fun onSuccess(data: List<ProjectListDataModel>) {
                callback.onSuccess(data)
            }

            override fun onError(error: Throwable) {
                callback.onError(error)
            }

        })
    }
}