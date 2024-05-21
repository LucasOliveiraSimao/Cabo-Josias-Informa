package com.lucassimao.cabojosiasinforma.home.data

import com.lucassimao.cabojosiasinforma.home.data.model.HomeDataModel
import com.lucassimao.cabojosiasinforma.home.data.source.HomeDataSource
import com.lucassimao.cabojosiasinforma.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource
) : HomeRepository {
    override fun fetchHomeCards(): List<HomeDataModel> {
        return homeDataSource.fetchCards()
    }
}