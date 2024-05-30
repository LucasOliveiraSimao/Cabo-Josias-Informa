package com.lucassimao.cabojosiasinforma.home.presentation.mapper

import com.lucassimao.cabojosiasinforma.home.data.model.HomeDataModel
import com.lucassimao.cabojosiasinforma.home.presentation.model.HomeUiModel

fun HomeDataModel.toDomainModel(): HomeUiModel {
    return HomeUiModel(
        icon = icon,
        title = title,
        type = type
    )
}

fun HomeUiModel.toDataModel(): HomeDataModel {
    return HomeDataModel(
        icon = icon,
        title = title,
        type = type
    )
}