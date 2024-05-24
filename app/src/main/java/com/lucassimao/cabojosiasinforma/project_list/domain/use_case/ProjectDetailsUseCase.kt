package com.lucassimao.cabojosiasinforma.project_list.domain.use_case

import com.lucassimao.cabojosiasinforma.project_list.domain.repository.ProjectListRepository
import javax.inject.Inject

class ProjectDetailsUseCase @Inject constructor(
    private val projectListRepository: ProjectListRepository
) {
    fun getProjectDetails(id: Int) = projectListRepository.getProjectDetails(id)
}