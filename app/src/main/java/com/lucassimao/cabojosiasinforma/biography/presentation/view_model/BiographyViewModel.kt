package com.lucassimao.cabojosiasinforma.biography.presentation.view_model

import androidx.lifecycle.ViewModel
import com.lucassimao.cabojosiasinforma.biography.domain.use_case.BiographyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BiographyViewModel @Inject constructor(
    private val biographyUseCase: BiographyUseCase
) : ViewModel() {
    fun fetchBiography() = biographyUseCase.fetchBiography()
}