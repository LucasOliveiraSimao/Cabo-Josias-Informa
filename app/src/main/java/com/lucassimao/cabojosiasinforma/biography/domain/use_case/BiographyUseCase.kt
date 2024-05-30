package com.lucassimao.cabojosiasinforma.biography.domain.use_case

import com.lucassimao.cabojosiasinforma.biography.domain.repository.BiographyRepository
import javax.inject.Inject

class BiographyUseCase @Inject constructor(
    private val biographyRepository: BiographyRepository
) {
    fun fetchBiography() = biographyRepository.fetchBiography()
}