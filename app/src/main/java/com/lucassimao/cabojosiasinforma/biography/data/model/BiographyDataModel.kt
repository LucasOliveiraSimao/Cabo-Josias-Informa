package com.lucassimao.cabojosiasinforma.biography.data.model

data class BiographyDataModel(
    val title: String = "",
    val description: String = "",
    val urlImg: String = ""
) {
    constructor() : this("", "", "")
}
