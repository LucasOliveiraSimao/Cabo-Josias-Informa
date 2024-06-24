package com.lucassimao.cabojosiasinforma.project_list.data.source.remote.callback

import com.google.firebase.database.DatabaseError
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel

interface ProjectListCallback {
    fun onSuccess(projectList: List<ProjectListDataModel>)
    fun onError(error: DatabaseError)
}