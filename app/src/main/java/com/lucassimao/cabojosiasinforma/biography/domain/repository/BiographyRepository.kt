package com.lucassimao.cabojosiasinforma.biography.domain.repository

import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel
import com.lucassimao.cabojosiasinforma.core.callback.RepositoryCallback

interface BiographyRepository {
    fun fetchBiography(callback: RepositoryCallback<BiographyDataModel>)
}