package com.lucassimao.cabojosiasinforma.biography.data.source

import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel

interface BiographyDataSource {
    fun fetchBiography(): List<BiographyDataModel>
}