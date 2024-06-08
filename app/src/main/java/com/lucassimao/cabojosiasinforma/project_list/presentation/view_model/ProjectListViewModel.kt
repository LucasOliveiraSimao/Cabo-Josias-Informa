package com.lucassimao.cabojosiasinforma.project_list.presentation.view_model

import androidx.lifecycle.ViewModel
import com.lucassimao.cabojosiasinforma.core.ui.UiState
import com.lucassimao.cabojosiasinforma.core.callback.UseCaseCallback
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel
import com.lucassimao.cabojosiasinforma.project_list.domain.use_case.ProjectListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProjectListViewModel @Inject constructor(
    private val projectListUseCase: ProjectListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<ProjectListDataModel>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<ProjectListDataModel>>> get() = _uiState

    fun fetchProjectList() {
        _uiState.value = UiState.Loading
        projectListUseCase.fetchProjectList(object : UseCaseCallback<List<ProjectListDataModel>> {
            override fun onSuccess(data: List<ProjectListDataModel>) {
                _uiState.value = UiState.Success(data)
            }

            override fun onError(error: Throwable) {
                _uiState.value = UiState.Error(error)
            }

        })
    }
}