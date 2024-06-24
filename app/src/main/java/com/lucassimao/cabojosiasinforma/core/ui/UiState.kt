package com.lucassimao.cabojosiasinforma.core.ui

sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val throwable: Throwable) : UiState<Nothing>()
}