package com.lucassimao.cabojosiasinforma.project.presentation.view_model

import androidx.lifecycle.ViewModel
import com.lucassimao.cabojosiasinforma.project_list.domain.use_case.ProjectListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProjectListViewModel @Inject constructor(
    private val projectListUseCase: ProjectListUseCase
) : ViewModel() {
    fun fetchProjectList() = projectListUseCase.fetchProjectList()
}