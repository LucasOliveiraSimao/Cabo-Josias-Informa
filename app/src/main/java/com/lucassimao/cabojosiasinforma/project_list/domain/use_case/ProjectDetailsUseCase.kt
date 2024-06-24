package com.lucassimao.cabojosiasinforma.project_list.domain.use_case

import com.lucassimao.cabojosiasinforma.core.callback.RepositoryCallback
import com.lucassimao.cabojosiasinforma.core.callback.UseCaseCallback
import com.lucassimao.cabojosiasinforma.project_list.domain.model.ProjectDomainModel
import com.lucassimao.cabojosiasinforma.project_list.domain.repository.ProjectListRepository
import javax.inject.Inject

class ProjectDetailsUseCase @Inject constructor(
    private val projectListRepository: ProjectListRepository
) {
    fun getProjectDetails(id: Int, callback: UseCaseCallback<ProjectDomainModel>) {
        projectListRepository.getProjectDetails(
            id,
            object : RepositoryCallback<ProjectDomainModel> {
                override fun onSuccess(data: ProjectDomainModel) {
                    callback.onSuccess(data)
                }

                override fun onError(error: Throwable) {
                    callback.onError(error)
                }
            })
    }
}