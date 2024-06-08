package com.lucassimao.cabojosiasinforma.project_list.presentation.view_model

import androidx.lifecycle.ViewModel
import com.lucassimao.cabojosiasinforma.core.callback.UseCaseCallback
import com.lucassimao.cabojosiasinforma.core.ui.UiState
import com.lucassimao.cabojosiasinforma.project_list.domain.model.ProjectDomainModel
import com.lucassimao.cabojosiasinforma.project_list.domain.model.ProjectUiModel
import com.lucassimao.cabojosiasinforma.project_list.domain.use_case.ProjectDetailsUseCase
import com.lucassimao.cabojosiasinforma.project_list.presentation.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProjectDetailsViewModel @Inject constructor(
    private val projectDetailsUseCase: ProjectDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<ProjectUiModel>>(UiState.Loading)
    val uiState: StateFlow<UiState<ProjectUiModel>> get() = _uiState
    fun getProjectDetails(id: Int) {
        _uiState.value = UiState.Loading
        projectDetailsUseCase.getProjectDetails(id, object : UseCaseCallback<ProjectDomainModel> {
            override fun onSuccess(data: ProjectDomainModel) {
                _uiState.value = UiState.Success(data.toUiModel())
            }

            override fun onError(error: Throwable) {
                _uiState.value = UiState.Error(error)
            }

        })
    }
}