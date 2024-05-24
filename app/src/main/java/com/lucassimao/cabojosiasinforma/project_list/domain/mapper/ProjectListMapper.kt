package com.lucassimao.cabojosiasinforma.project_list.domain.mapper

import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel
import com.lucassimao.cabojosiasinforma.project_list.domain.model.ProjectListDomainModel

fun ProjectListDataModel.toDomainModel(): ProjectListDomainModel {
    return ProjectListDomainModel(
        id = id,
        title = title
    )
}

fun ProjectListDomainModel.toDataModel(): ProjectListDataModel {
    return ProjectListDataModel(
        id = id,
        title = title
    )
}