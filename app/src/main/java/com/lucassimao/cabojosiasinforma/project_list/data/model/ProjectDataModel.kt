package com.lucassimao.cabojosiasinforma.project_list.data.model

data class ProjectDataModel(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val objectives: List<String> = listOf(),
    val actions: List<ActionDataModel> = listOf(),
    val createdAt: String = "",
    val updatedAt: String = ""
) {
    constructor() : this(0, "", "", listOf(), listOf(), "", "")
}