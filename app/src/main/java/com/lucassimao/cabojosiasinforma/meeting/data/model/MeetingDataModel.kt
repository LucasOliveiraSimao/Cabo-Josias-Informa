package com.lucassimao.cabojosiasinforma.meeting.data.model

import com.lucassimao.cabojosiasinforma.core.ui.share.Shareable

data class MeetingDataModel(
    var id: Int = 0,
    val title: String = "",
    val date: String = "",
    val location: String = "",
    val objective: String = "",
    val participants: String = ""
) : Shareable {
    constructor() : this(0, "", "", "", "", "")

    override fun getShareableContent(): String {
        return buildString {
            append("Venha participar deste encontro com o nosso candidato a vereador, Cabo Josias: \n\n")
            append(title + "\n\n")
            append(date + "\n\n")
            append(location + "\n\n")
            append(objective + "\n\n")
            append(participants + "\n\n")
        }
    }
}
