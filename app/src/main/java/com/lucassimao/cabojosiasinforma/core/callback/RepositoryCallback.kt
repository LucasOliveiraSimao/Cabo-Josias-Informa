package com.lucassimao.cabojosiasinforma.core.callback

interface RepositoryCallback<T> {
    fun onSuccess(data: T)
    fun onError(error: Throwable)
}