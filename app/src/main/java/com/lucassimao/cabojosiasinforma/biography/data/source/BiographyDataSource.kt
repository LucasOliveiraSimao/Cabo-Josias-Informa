package com.lucassimao.cabojosiasinforma.biography.data.source

import com.lucassimao.cabojosiasinforma.biography.data.source.remote.BiographyCallback

interface BiographyDataSource {
    fun fetchBiography(callback: BiographyCallback)
}