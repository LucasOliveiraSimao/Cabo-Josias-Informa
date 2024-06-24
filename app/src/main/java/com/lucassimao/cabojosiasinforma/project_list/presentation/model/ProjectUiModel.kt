package com.lucassimao.cabojosiasinforma.project_list.presentation.model

import com.lucassimao.cabojosiasinforma.core.ui.share.Shareable
import com.lucassimao.cabojosiasinforma.project_list.data.model.ActionDataModel

data class ProjectUiModel(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val objectives: List<String> = listOf(),
    val actions: List<ActionDataModel> = listOf(),
) : Shareable {
    override fun getShareableContent(): String {
        return buildString {
            append("Conheça uma das propostas do nosso candidato a vereador, Cabo Josias, para o nosso município: \n\n")
            append(title + "\n\n")
            append(description + "\n\n")
            objectives.forEach {
                append(it + "\n\n")
            }
            actions.forEach {
                append(it.title + "\n\n")
                append(it.description + "\n\n")
            }
        }
    }

}