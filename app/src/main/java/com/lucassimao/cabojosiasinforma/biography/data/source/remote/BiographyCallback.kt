package com.lucassimao.cabojosiasinforma.biography.data.source.remote

import com.google.firebase.database.DatabaseError
import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel

interface BiographyCallback {
    fun onSuccess(biography: BiographyDataModel)
    fun onError(error: DatabaseError)
}