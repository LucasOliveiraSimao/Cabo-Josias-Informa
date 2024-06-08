package com.lucassimao.cabojosiasinforma.project_list.domain.model

import com.lucassimao.cabojosiasinforma.project_list.data.model.ActionDataModel

data class ProjectUiModel(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val objectives: List<String> = listOf(),
    val actions: List<ActionDataModel> = listOf(),
)