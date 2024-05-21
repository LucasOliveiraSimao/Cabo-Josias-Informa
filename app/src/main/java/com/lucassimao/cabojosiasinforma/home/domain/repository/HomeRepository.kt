package com.lucassimao.cabojosiasinforma.home.domain.repository

import com.lucassimao.cabojosiasinforma.home.data.model.HomeDataModel

interface HomeRepository {
    fun fetchHomeCards(): List<HomeDataModel>
}