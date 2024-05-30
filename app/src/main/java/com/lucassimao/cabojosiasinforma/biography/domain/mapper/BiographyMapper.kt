package com.lucassimao.cabojosiasinforma.biography.domain.mapper

import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel
import com.lucassimao.cabojosiasinforma.biography.domain.model.BiographyDomainModel
import com.lucassimao.cabojosiasinforma.biography.presentation.model.BiographyUiModel

fun BiographyDataModel.toDomainModel(): BiographyDomainModel {
    return BiographyDomainModel(
        description = description
    )
}

fun BiographyDomainModel.toUiModel(): BiographyUiModel {
    return BiographyUiModel(
        description = description
    )
}