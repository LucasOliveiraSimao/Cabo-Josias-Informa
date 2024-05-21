package com.lucassimao.cabojosiasinforma.home.domain.use_case

import com.lucassimao.cabojosiasinforma.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    fun invoke() = homeRepository.fetchHomeCards()
}