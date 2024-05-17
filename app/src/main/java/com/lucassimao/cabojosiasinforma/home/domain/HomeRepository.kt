package com.lucassimao.cabojosiasinforma.home.domain

import com.lucassimao.cabojosiasinforma.home.data.source.HomeCardModel

interface HomeRepository {
    fun fetchHomeCards(): List<HomeCardModel>
}