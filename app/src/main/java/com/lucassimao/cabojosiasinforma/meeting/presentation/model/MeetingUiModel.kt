package com.lucassimao.cabojosiasinforma.meeting.presentation.model

import com.lucassimao.cabojosiasinforma.core.Screens

data class MeetingUiModel(
    val title: String,
    val date: String,
    val location: String,
    val objective: String,
    val participants: String
)
