package com.lucassimao.cabojosiasinforma.biography.data

import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel
import com.lucassimao.cabojosiasinforma.biography.data.source.BiographyDataSource
import com.lucassimao.cabojosiasinforma.biography.domain.repository.BiographyRepository
import javax.inject.Inject

class BiographyRepositoryImpl @Inject constructor(
    private val biographyDataSource: BiographyDataSource
) : BiographyRepository {
    override fun fetchBiography(): List<BiographyDataModel> {
        return biographyDataSource.fetchBiography()
    }
}