package com.lucassimao.cabojosiasinforma.project_list.presentation.mapper

import com.lucassimao.cabojosiasinforma.project_list.domain.model.ProjectDomainModel
import com.lucassimao.cabojosiasinforma.project_list.domain.model.ProjectUiModel

fun ProjectDomainModel.toUiModel(): ProjectUiModel {
    return ProjectUiModel(
        title = title,
        description = description,
        objectives = objectives,
        actions = actions
    )
}

fun ProjectUiModel.toDomainModel(): ProjectDomainModel {
    return ProjectDomainModel(
        id = id,
        title = title,
        description = description,
        objectives = objectives,
        actions = actions,
    )
}