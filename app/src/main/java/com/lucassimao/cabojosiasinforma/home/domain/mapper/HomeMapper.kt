package com.lucassimao.cabojosiasinforma.home.domain.mapper

import com.lucassimao.cabojosiasinforma.home.data.model.HomeDataModel
import com.lucassimao.cabojosiasinforma.home.domain.model.HomeDomainModel
import com.lucassimao.cabojosiasinforma.home.presentation.model.HomeUiModel

fun HomeDataModel.toDomainModel(): HomeDomainModel {
    return HomeDomainModel(
        icon = icon,
        title = title,
        type = type
    )
}

fun HomeDomainModel.toUiModel(): HomeUiModel {
    return HomeUiModel(
        icon = icon,
        title = title,
        type = type
    )
}