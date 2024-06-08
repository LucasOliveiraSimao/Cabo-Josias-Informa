package com.lucassimao.cabojosiasinforma.project_list.domain.mapper

import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectDataModel
import com.lucassimao.cabojosiasinforma.project_list.domain.model.ProjectDomainModel

fun ProjectDataModel.toDomainModel(): ProjectDomainModel {
    return ProjectDomainModel(
        title = title,
        description = description,
        objectives = objectives,
        actions = actions
    )
}

fun ProjectDomainModel.toDataModel(): ProjectDataModel {
    return ProjectDataModel(
        id = id,
        title = title,
        description = description,
        objectives = objectives,
        actions = actions,
        createdAt = "",
        updatedAt = ""
    )
}