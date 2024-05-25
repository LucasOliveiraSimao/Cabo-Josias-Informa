package com.lucassimao.cabojosiasinforma.home.data.source.remote

import com.lucassimao.cabojosiasinforma.R
import com.lucassimao.cabojosiasinforma.core.Screens
import com.lucassimao.cabojosiasinforma.home.data.model.HomeDataModel
import com.lucassimao.cabojosiasinforma.home.data.source.HomeDataSource
import javax.inject.Inject

class HomeFakeRemoteDataSource @Inject constructor() : HomeDataSource {
    override fun fetchCards(): List<HomeDataModel> {
        return listOf(
            HomeDataModel(
                icon = R.drawable.ic_person,
                title = "Biografia",
                type = Screens.BIOGRAPHY
            ),
            HomeDataModel(
                icon = R.drawable.ic_projects,
                title = "Projetos",
                type = Screens.PROJECTS
            ),
            HomeDataModel(
                icon = R.drawable.ic_calendar,
                title = "Agenda de Eventos e Reunião",
                type = Screens.MEETING
            ),
//            HomeDataModel(
//                icon = R.drawable.ic_notifications,
//                title = "Notificações de Problemas",
//                type = Screens.NOTIFICATIONS
//            )
        )
    }

}