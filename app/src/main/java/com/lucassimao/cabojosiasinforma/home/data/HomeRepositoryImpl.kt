package com.lucassimao.cabojosiasinforma.home.data

import com.lucassimao.cabojosiasinforma.home.data.source.HomeCardModel
import com.lucassimao.cabojosiasinforma.home.data.source.HomeDataSource
import com.lucassimao.cabojosiasinforma.home.domain.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource
) : HomeRepository {
    override fun fetchHomeCards(): List<HomeCardModel> {
        return homeDataSource.fetchCards()
    }
}