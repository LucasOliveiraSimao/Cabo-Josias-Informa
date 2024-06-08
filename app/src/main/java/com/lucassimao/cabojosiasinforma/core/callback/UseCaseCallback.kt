package com.lucassimao.cabojosiasinforma.core.callback

interface UseCaseCallback<T> {
    fun onSuccess(data: T)
    fun onError(error: Throwable)
}
