package com.lucassimao.cabojosiasinforma.biography.domain.repository

import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel

interface BiographyRepository {
    fun fetchBiography(): List<BiographyDataModel>
}