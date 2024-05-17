package com.lucassimao.cabojosiasinforma.home.data.source

interface HomeDataSource {
    fun fetchCards(): List<HomeCardModel>
}