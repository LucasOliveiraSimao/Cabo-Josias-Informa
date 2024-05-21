package com.lucassimao.cabojosiasinforma.home.data.source

import com.lucassimao.cabojosiasinforma.home.data.model.HomeDataModel

interface HomeDataSource {
    fun fetchCards(): List<HomeDataModel>
}