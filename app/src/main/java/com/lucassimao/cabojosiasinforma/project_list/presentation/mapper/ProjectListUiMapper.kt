package com.lucassimao.cabojosiasinforma.project_list.presentation.mapper

import com.lucassimao.cabojosiasinforma.project_list.domain.model.ProjectListDomainModel
import com.lucassimao.cabojosiasinforma.project_list.presentation.model.ProjectListUiModel

fun ProjectListDomainModel.toUiModel(): ProjectListUiModel {
    return ProjectListUiModel(
        id = id,
        title = title
    )
}

fun ProjectListUiModel.toDomainModel(): ProjectListDomainModel {
    return ProjectListDomainModel(
        id = id,
        title = title
    )
}