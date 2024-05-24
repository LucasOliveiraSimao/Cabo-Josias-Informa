package com.lucassimao.cabojosiasinforma.project_list.data.source.remote

import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectDetailsDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.source.ProjectListDataSource
import javax.inject.Inject

class ProjectListFakeRemoteListDataSource @Inject constructor() : ProjectListDataSource {
    override fun fetchProjectList(): List<ProjectListDataModel> {
        return listOf(
            ProjectListDataModel(
                id = 1,
                title = "Projeto Aulões Solidários para Vertibular"
            ),
            ProjectListDataModel(
                id = 2,
                title = "Apoio ás Instituições Religiosas"
            ),
            ProjectListDataModel(
                id = 3,
                title = "Assistência Social"
            ),
            ProjectListDataModel(
                id = 4,
                title = "Apoio ao Esporte Amador e Profissional"
            )
        )
    }

    override fun getProjectDetails(id: Int): ProjectDetailsDataModel {
        return projectDetailsList().first { it.id == id }
    }

    private fun projectDetailsList() = listOf(
        ProjectDetailsDataModel(
            id = 1,
            title = "Projeto Aulões Solidários para Vertibular",
            description = "A educação é a base para o desenvolvimento sustentável e a construção de uma sociedade justa e igualitária. No nosso município, muitos jovens enfrentam dificuldades para se preparar adequadamente para os vestibulares, principalmente aqueles em situação de vulnerabilidade social. Para mudar essa realidade, proponho a criação de aulões solidários para vestibular, em parceria com a Universidade Federal do Amazonas (UFAM), proporcionando acesso gratuito e de qualidade à preparação para os exames.\n" +
                    "\n" +
                    "Objetivos da Proposta:\n" +
                    "1. Democratizar o acesso à educação de qualidade:\n" +
                    "   - Oferecer preparação gratuita para vestibulares aos estudantes do município, especialmente os de baixa renda.\n" +
                    "   \n" +
                    "2. Fortalecer a parceria com a UFAM:\n" +
                    "   - Estabelecer uma colaboração contínua com a UFAM para aproveitar o conhecimento e a expertise de seus docentes e alunos.\n" +
                    "\n" +
                    "3. Incentivar a inclusão social e a igualdade de oportunidades:\n" +
                    "   - Garantir que todos os estudantes, independentemente de sua condição socioeconômica, tenham a chance de ingressar em uma universidade pública.\n" +
                    "\n" +
                    "Propostas de Ação:\n" +
                    "\n" +
                    "1. Criação dos Aulões Solidários para Vestibular:\n" +
                    "   - Organizar aulões preparatórios gratuitos para os principais vestibulares, com foco no Exame Nacional do Ensino Médio (ENEM) e nos processos seletivos da UFAM.\n" +
                    "   - As aulas serão ministradas por professores voluntários.\n" +
                    "\n" +
                    "2. Parceria com a UFAM:\n" +
                    "   - Firmar um acordo de cooperação com a UFAM para a participação de seus docentes e alunos nos aulões, além do uso de suas instalações e recursos pedagógicos.\n" +
                    "   - Promover oficinas e palestras conduzidas por professores e pesquisadores da UFAM sobre temas relevantes para o vestibular e para o desenvolvimento acadêmico dos estudantes."
        ),
        ProjectDetailsDataModel(
            id = 2,
            title = "Apoio as Instituições Religiosas",
            description = "As instituições religiosas desempenham um papel fundamental no desenvolvimento social, moral e espiritual da nossa comunidade. Elas não apenas promovem valores éticos e de solidariedade, mas também atuam como pilares de apoio em momentos de necessidade, oferecendo ajuda humanitária, aconselhamento e diversas formas de assistência social. Reconhecendo a importância dessas instituições, apresento minha proposta de apoio às instituições religiosas do nosso município.\n" +
                    "\n" +
                    "1. Fortalecer o papel social das instituições religiosas:\n" +
                    "   - Apoiar iniciativas que promovam a inclusão social, combate à fome, acolhimento de pessoas em situação de rua e apoio a dependentes químicos.\n" +
                    "\n" +
                    "2. Incentivar a preservação do patrimônio cultural e religioso:\n" +
                    "   - Proteger e revitalizar edifícios religiosos históricos, garantindo que sejam preservados como parte do nosso patrimônio cultural.\n" +
                    "\n" +
                    "3. Promover a colaboração entre governo e instituições religiosas:\n" +
                    "   - Facilitar o diálogo e a parceria entre o poder público e as instituições religiosas para a implementação de programas sociais e culturais.\n" +
                    "\n" +
                    "Propostas de Ação:\n" +
                    "\n" +
                    "1. Criação de um Fundo Municipal de Apoio às Instituições Religiosas:\n" +
                    "   - Estabelecer um fundo específico no orçamento municipal para apoiar financeiramente projetos sociais e culturais desenvolvidos por instituições religiosas. Este fundo poderá ser utilizado para reformas, manutenção de espaços, realização de eventos culturais e aquisição de materiais para ações sociais.\n" +
                    "\n" +
                    "2. Capacitação e Formação:\n" +
                    "   - Oferecer programas de capacitação para líderes religiosos e voluntários, abordando temas como gestão de projetos sociais, captação de recursos, direitos humanos e cidadania.\n" +
                    "\n" +
                    "3. Parcerias para Projetos Sociais:\n" +
                    "   - Estabelecer parcerias entre a prefeitura e as instituições religiosas para a execução de projetos sociais em áreas como educação, saúde, assistência social e combate à violência.\n" +
                    "\n" +
                    "4. Apoio Logístico e Estrutural:\n" +
                    "   - Disponibilizar suporte logístico e estrutural, como transporte e locais para realização de eventos, facilitando a atuação das instituições religiosas em suas ações comunitárias."
        ),
        ProjectDetailsDataModel(
            id = 3,
            title = "Assistencia Social",
            description = "A assistência social é um dos pilares fundamentais para a construção de uma sociedade justa e igualitária. No nosso município, muitas famílias enfrentam desafios diários relacionados à pobreza, falta de acesso a serviços básicos e exclusão social. Como candidato a vereador, proponho um conjunto de ações voltadas para fortalecer a rede de assistência social, garantindo suporte efetivo e dignidade a todos os cidadãos.\n" +
                    "\n" +
                    "Objetivos da Proposta:\n" +
                    "   \n" +
                    "1. Fortalecer a rede de proteção social:\n" +
                    "   - Ampliar e melhorar os serviços de assistência social disponíveis, garantindo que todos tenham acesso aos recursos necessários.\n" +
                    "\n" +
                    "2. Promover a inclusão e o desenvolvimento social:\n" +
                    "   - Criar oportunidades de educação, capacitação profissional e geração de renda para os grupos mais vulneráveis.\n" +
                    "\n" +
                    "Propostas de Ação:\n" +
                    "\n" +
                    "1. Fortalecimento do CRAS (Centro de Referência de Assistência Social):*\n" +
                    "   - Ampliar a atuação do CRAS, aumentando o número de unidades e profissionais, e garantindo um atendimento mais eficaz e abrangente às famílias em situação de risco.\n" +
                    "\n" +
                    "2. Capacitação e Qualificação Profissional:\n" +
                    "   - Desenvolver programas de capacitação profissional em parceria com instituições de ensino e empresas locais, visando a inclusão no mercado de trabalho e a geração de renda.\n" +
                    "\n" +
                    "3. Apoio à População de Rua:\n" +
                    "   - Implementar um programa específico para a população em situação de rua, incluindo acolhimento, atendimento médico, psicológico e programas de reintegração social e profissional.\n" +
                    "\n" +
                    "4. Assistência à Infância e Juventude:\n" +
                    "   - Criar projetos voltados para crianças e jovens, oferecendo atividades extracurriculares, apoio escolar e programas de prevenção à violência e ao uso de drogas.\n" +
                    "\n" +
                    "5. Valorização dos Idosos:\n" +
                    "   - Desenvolver programas de assistência e inclusão para a terceira idade, promovendo atividades culturais, de lazer e saúde, além de garantir apoio social e jurídico.\n" +
                    "\n" +
                    "6. Parcerias com ONGs e Iniciativa Privada:\n" +
                    "   - Estabelecer parcerias estratégicas com organizações não-governamentais e empresas locais para potencializar as ações de assistência social e ampliar os recursos disponíveis."
        ),
        ProjectDetailsDataModel(
            id = 4,
            title = "Apoio ao Esporte Amador e Profissional",
            description = "O esporte é uma ferramenta poderosa de transformação social, promovendo saúde, inclusão e desenvolvimento humano. No nosso município, o esporte amador e profissional precisa de mais apoio para revelar talentos, incentivar a prática esportiva entre jovens e adultos, e proporcionar qualidade de vida para toda a comunidade. Como candidato a vereador, apresento uma proposta abrangente para fortalecer o esporte amador e profissional no nosso município.\n" +
                    "\n" +
                    "Objetivos da Proposta:\n" +
                    "1. Promover a inclusão social e a saúde por meio do esporte:\n" +
                    "   - Incentivar a prática esportiva em todas as faixas etárias e classes sociais.\n" +
                    "   \n" +
                    "2. Fortalecer as estruturas esportivas:\n" +
                    "   - Melhorar e ampliar as instalações e equipamentos esportivos do município.\n" +
                    "\n" +
                    "3. Apoiar atletas e equipes locais:\n" +
                    "   - Oferecer suporte financeiro, técnico e logístico para atletas amadores e profissionais.\n" +
                    "\n" +
                    "Propostas de Ação:\n" +
                    "\n" +
                    "1. Melhoria das Infraestruturas Esportivas:\n" +
                    "   - Reformar e construir quadras, campos, ginásios e pistas de atletismo em diferentes bairros, garantindo que todas as regiões do município tenham acesso a instalações de qualidade.\n" +
                    "   - Implementar programas de manutenção regular para assegurar que as instalações permaneçam em boas condições de uso.\n" +
                    "\n" +
                    "2. Programas de Incentivo ao Esporte Escolar:\n" +
                    "   - Desenvolver parcerias com escolas para incentivar a prática esportiva desde a infância, promovendo torneios inter-escolares e oferecendo suporte para a formação de equipes esportivas.\n" +
                    "\n" +
                    "3. Realização de Eventos e Competições:\n" +
                    "   - Promover campeonatos municipais em diversas modalidades esportivas, incentivando a participação da comunidade e revelando novos talentos.\n" +
                    "   - Organizar eventos esportivos abertos à população, como corridas de rua, torneios de bairro e festivais esportivos.\n" +
                    "\n" +
                    "4. Incentivo ao Esporte para Pessoas com Deficiência:\n" +
                    "   - Implementar programas específicos para inclusão de pessoas com deficiência no esporte, garantindo acessibilidade nas instalações esportivas e oferecendo treinamentos adaptados.\n" +
                    "\n" +
                    "5. Esporte como Ferramenta de Inclusão Social:\n" +
                    "   - Desenvolver projetos que utilizem o esporte como meio de inclusão social, especialmente em áreas de vulnerabilidade, promovendo atividades esportivas que afastem os jovens da criminalidade e das drogas.\n" +
                    "\n" +
                    "6. Formação e Capacitação de Profissionais:\n" +
                    "   - Oferecer cursos de formação e capacitação para técnicos, treinadores e gestores esportivos, garantindo que o município tenha profissionais qualificados para orientar os atletas."
        )
    )
}