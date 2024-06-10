package com.lucassimao.cabojosiasinforma.biography.data

import com.google.firebase.database.DatabaseError
import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel
import com.lucassimao.cabojosiasinforma.biography.data.source.BiographyDataSource
import com.lucassimao.cabojosiasinforma.biography.data.source.remote.BiographyCallback
import com.lucassimao.cabojosiasinforma.biography.domain.repository.BiographyRepository
import com.lucassimao.cabojosiasinforma.core.callback.RepositoryCallback
import javax.inject.Inject

class BiographyRepositoryImpl @Inject constructor(
    private val biographyDataSource: BiographyDataSource
) : BiographyRepository {
    override fun fetchBiography(callback: RepositoryCallback<BiographyDataModel>) {
        return biographyDataSource.fetchBiography(object : BiographyCallback {
            override fun onSuccess(biography: BiographyDataModel) {
                callback.onSuccess(biography)
            }

            override fun onError(error: DatabaseError) {
                callback.onError(error.toException())
            }

        })
    }
}