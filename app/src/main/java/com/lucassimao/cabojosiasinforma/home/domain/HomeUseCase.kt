package com.lucassimao.cabojosiasinforma.home.domain

import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    fun invoke() = homeRepository.fetchHomeCards()
}