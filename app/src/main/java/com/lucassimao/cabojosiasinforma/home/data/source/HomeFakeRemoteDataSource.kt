package com.lucassimao.cabojosiasinforma.home.data.source

import com.lucassimao.cabojosiasinforma.R
import com.lucassimao.cabojosiasinforma.core.Screens
import javax.inject.Inject

class HomeFakeRemoteDataSource @Inject constructor() : HomeDataSource {
    override fun fetchCards(): List<HomeCardModel> {
        return listOf(
            HomeCardModel(
                icon = R.drawable.ic_person,
                title = "Biografia",
                type = Screens.BIOGRAPHY
            ),
            HomeCardModel(
                icon = R.drawable.ic_projects,
                title = "Projetos",
                type = Screens.PROJECTS
            ),
            HomeCardModel(
                icon = R.drawable.ic_calendar,
                title = "Agendamento de Reunião",
                type = Screens.MEETING
            ),
            HomeCardModel(
                icon = R.drawable.ic_notifications,
                title = "Notificações de Problemas",
                type = Screens.NOTIFICATIONS
            )
        )
    }

}