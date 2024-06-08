package com.lucassimao.cabojosiasinforma.meeting.domain.model

data class MeetingDomainModel(
    val title: String,
    val date: String,
    val location: String,
    val objective: String,
    val participants: String
)