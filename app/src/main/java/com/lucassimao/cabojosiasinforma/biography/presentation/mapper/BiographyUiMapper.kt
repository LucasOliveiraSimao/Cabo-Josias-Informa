package com.lucassimao.cabojosiasinforma.biography.presentation.mapper

import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel
import com.lucassimao.cabojosiasinforma.biography.presentation.model.BiographyUiModel

fun BiographyDataModel.toDomainModel(): BiographyUiModel {
    return BiographyUiModel(
        description = description
    )
}

fun BiographyUiModel.toDataModel(): BiographyDataModel {
    return BiographyDataModel(
        description = description
    )
}