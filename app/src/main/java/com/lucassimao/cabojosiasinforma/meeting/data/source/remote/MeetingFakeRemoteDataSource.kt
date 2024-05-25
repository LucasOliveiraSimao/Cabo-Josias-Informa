package com.lucassimao.cabojosiasinforma.meeting.data.source.remote

import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel
import com.lucassimao.cabojosiasinforma.meeting.data.source.MeetingDataSource
import javax.inject.Inject

class MeetingFakeRemoteDataSource @Inject constructor() : MeetingDataSource {
    override fun fetchMeetings(): List<MeetingDataModel> {
        return listOf(
            MeetingDataModel(
                title = "Reunião com a Comunidade do Bairro Vila Nova",
                date = "Data: 25 de maio de 2024\n" +
                        "Horário: 10:00 - 12:00",
                location = "Local: Centro Comunitário da Vila Nova",
                objective = "Objetivo: Discutir melhorias na infraestrutura do bairro, como pavimentação de ruas e manutenção de áreas verdes.",
                participants = "Participantes:\n" +
                        "Vereador João Silva\n" +
                        "Líderes comunitários\n" +
                        "Moradores do bairro\n" +
                        "Representantes da Secretaria de Obras"
            ),
            MeetingDataModel(
                title = "Visita à Escola Municipal Paulo Freire",
                date = "Data: 26 de maio de 2024\n" +
                        "Horário: 14:00 - 16:00",
                location = "Local: Escola Municipal Paulo Freire",
                objective = "Objetivo: Verificar as condições das instalações escolares e discutir a implementação de novos programas educacionais.",
                participants = "Participantes:\n" +
                        "Vereador João Silva\n" +
                        "Diretor da escola\n" +
                        "Professores\n" +
                        "Pais de alunos\n" +
                        "Representantes da Secretaria de Educação"
            ),
            MeetingDataModel(
                title = "Audiência Pública sobre Segurança no Trânsito",
                date = "Data: 27 de maio de 2024\n" +
                        "Horário: 18:00 - 20:00",
                location = "Local: Câmara Municipa",
                objective = "Objetivo: Debater medidas para melhorar a segurança no trânsito, como a instalação de semáforos e lombadas em áreas de alto risco.",
                participants = "Participantes:\n" +
                        "Vereador João Silva\n" +
                        "Comandante da Polícia Militar\n" +
                        "Especialistas em trânsito\n" +
                        "Representantes da população\n" +
                        "Membros do Conselho de Trânsito"
            ),
            MeetingDataModel(
                title = " Reunião com Empresários Locais",
                date = "Data: 28 de maio de 2024\n" +
                        "Horário: 09:00 - 11:00",
                location = "Local: Associação Comercial da Cidade",
                objective = "Objetivo: Discutir incentivos fiscais e estratégias para promover o crescimento econômico local.\n",
                participants = "Participantes:\n" +
                        "Vereador João Silva\n" +
                        "Presidentes de associações comerciais\n" +
                        "Pequenos e médios empresários\n" +
                        "Representantes da Secretaria de Desenvolvimento Econômico"
            ),
            MeetingDataModel(
                title = "Sessão Solene em Homenagem ao Dia do Agricultor",
                date = "Data: 29 de maio de 2024\n" +
                        "Horário: 15:00 - 17:00",
                location = "Local: Câmara Municipal",
                objective = "Objetivo: Homenagear agricultores locais e discutir políticas de apoio à agricultura familiar",
                participants = "Participantes:\n" +
                        "Vereador João Silva\n" +
                        "Agricultores locais\n" +
                        "Representantes de cooperativas agrícolas\n" +
                        "Secretário de Agricultura"
            )
        )
    }
}