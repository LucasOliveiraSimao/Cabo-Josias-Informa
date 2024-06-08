package com.lucassimao.cabojosiasinforma.project_list.data.source

import com.lucassimao.cabojosiasinforma.project_list.data.source.remote.callback.ProjectCallback
import com.lucassimao.cabojosiasinforma.project_list.data.source.remote.callback.ProjectListCallback

interface ProjectListDataSource {
    fun fetchProjectList(callback: ProjectListCallback)
    fun getProjectDetails(id: Int, callback: ProjectCallback)
}