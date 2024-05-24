package com.lucassimao.cabojosiasinforma.project_list.domain.use_case

import com.lucassimao.cabojosiasinforma.project_list.domain.repository.ProjectListRepository
import javax.inject.Inject

class ProjectListUseCase @Inject constructor(
    private val projectListRepository: ProjectListRepository
) {
    fun fetchProjectList() = projectListRepository.fetchProjectList()
}