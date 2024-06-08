package com.lucassimao.cabojosiasinforma.project_list.data.model

data class ProjectListDataModel(
    val id: Int = 0,
    val title: String = ""
) {
    constructor() : this(0, "")
}