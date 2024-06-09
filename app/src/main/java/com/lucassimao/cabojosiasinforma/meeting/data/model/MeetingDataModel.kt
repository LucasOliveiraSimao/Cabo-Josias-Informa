package com.lucassimao.cabojosiasinforma.meeting.data.model

data class MeetingDataModel(
    var id: Int = 0,
    val title: String = "",
    val date: String = "",
    val location: String = "",
    val objective: String = "",
    val participants: String = ""
) {
    constructor() : this(0, "", "", "", "", "")
}
