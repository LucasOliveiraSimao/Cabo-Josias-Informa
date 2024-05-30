package com.lucassimao.cabojosiasinforma.biography.data.source.remote

import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel
import com.lucassimao.cabojosiasinforma.biography.data.source.BiographyDataSource
import javax.inject.Inject

class BiographyFakeRemoteDataSource @Inject constructor() : BiographyDataSource {
    override fun fetchBiography(): List<BiographyDataModel> {
        return listOf(
            BiographyDataModel(
                description = "Biografia de Josias Viana - Candidato a Vereador de Itacoatiara\n" +
                        "\n" +
                        "Josias Viana é um dedicado cabo da Polícia Militar, que tem servido com honra e integridade a comunidade de Itacoatiara por mais de 15 anos. Natural da própria cidade, Josias conhece de perto as necessidades e desafios enfrentados pelos seus conterrâneos, o que o motivou a se candidatar ao cargo de vereador, com o objetivo de promover mudanças significativas e melhorar a qualidade de vida de todos os moradores.\n" +
                        "\n" +
                        "Com um histórico exemplar de serviço público, Josias se destacou na Polícia Militar pelo seu compromisso com a segurança e bem-estar da população. Ele é conhecido por sua abordagem comunitária, sempre presente e acessível, buscando resolver conflitos de forma pacífica e eficaz.\n" +
                        "\n" +
                        "Como vereador, Josias Viana pretende ampliar suas ações em prol da segurança pública, propondo políticas que incentivem a colaboração entre a polícia e a comunidade. Além disso, ele planeja lutar por melhorias na educação, saúde e infraestrutura do município, sempre pautado pela ética e transparência.\n" +
                        "\n" +
                        "Josias acredita que uma gestão participativa é fundamental para o desenvolvimento de Itacoatiara. Por isso, ele se compromete a ouvir e representar fielmente os interesses da população, buscando sempre o diálogo e a construção coletiva de soluções.\n" +
                        "\n" +
                        "Com sua experiência, dedicação e profundo amor por Itacoatiara, Josias Viana é o candidato ideal para trazer uma nova perspectiva e promover avanços concretos no município. Seu lema é \"Segurança, Justiça e Desenvolvimento para Todos\", e ele está preparado para trabalhar incansavelmente para transformar essa visão em realidade."
            )
        )
    }
}