package com.lucassimao.cabojosiasinforma.project_list.data.source.remote.callback

import com.google.firebase.database.DatabaseError
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectDataModel

interface ProjectCallback {
    fun onSuccess(project: ProjectDataModel)
    fun onError(error: DatabaseError)
}