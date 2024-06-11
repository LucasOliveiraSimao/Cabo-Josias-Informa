package com.lucassimao.cabojosiasinforma.biography.domain.use_case

import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel
import com.lucassimao.cabojosiasinforma.biography.domain.repository.BiographyRepository
import com.lucassimao.cabojosiasinforma.core.callback.RepositoryCallback
import com.lucassimao.cabojosiasinforma.core.callback.UseCaseCallback
import javax.inject.Inject

class BiographyUseCase @Inject constructor(
    private val biographyRepository: BiographyRepository
) {
    fun fetchBiography(callback: UseCaseCallback<BiographyDataModel>) {
        biographyRepository.fetchBiography(object : RepositoryCallback<BiographyDataModel> {
            override fun onSuccess(data: BiographyDataModel) {
                callback.onSuccess(data)
            }

            override fun onError(error: Throwable) {
                callback.onError(error)
            }
        })
    }
}