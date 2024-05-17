package com.lucassimao.cabojosiasinforma.home.presentation

import androidx.lifecycle.ViewModel
import com.lucassimao.cabojosiasinforma.home.domain.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: HomeUseCase
) : ViewModel() {
    fun fetchHomeCards() = useCase.invoke()
}