package com.lucassimao.cabojosiasinforma.project_list.presentation.view_model

import androidx.lifecycle.ViewModel
import com.lucassimao.cabojosiasinforma.project_list.domain.use_case.ProjectDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProjectDetailsViewModel @Inject constructor(
    private val projectDetailsUseCase: ProjectDetailsUseCase
) : ViewModel() {
    fun getProjectDetails(id: Int) = projectDetailsUseCase.getProjectDetails(id)
}