package com.lucassimao.cabojosiasinforma.biography.presentation.view_model

import androidx.lifecycle.ViewModel
import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel
import com.lucassimao.cabojosiasinforma.biography.domain.use_case.BiographyUseCase
import com.lucassimao.cabojosiasinforma.core.callback.UseCaseCallback
import com.lucassimao.cabojosiasinforma.core.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BiographyViewModel @Inject constructor(
    private val biographyUseCase: BiographyUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<BiographyDataModel>>(UiState.Loading)
    val uiState: StateFlow<UiState<BiographyDataModel>> get() = _uiState
    fun fetchBiography() {
        _uiState.value = UiState.Loading
        biographyUseCase.fetchBiography(object : UseCaseCallback<BiographyDataModel> {
            override fun onSuccess(data: BiographyDataModel) {
                _uiState.value = UiState.Success(data)
            }

            override fun onError(error: Throwable) {
                _uiState.value = UiState.Error(error)
            }

        })
    }
}