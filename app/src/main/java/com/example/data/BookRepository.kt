package com.example.data

import com.example.model.BookSlide
import com.example.model.NeuralNode

object BookRepository {

    val slides: List<BookSlide> = listOf(
        BookSlide(
            id = "slide_1",
            title = "O3BR Ecosystem",
            subtitle = "Ecossistema de Inovação Furtiva & Mente Computacional",
            category = "Visão Geral",
            badge = "Apresentação Mestre",
            narrationText = "Bem-vindo ao Book de Apresentação do Ecossistema O3BR. O O3BR parte da extremidade para aplicar o que tem real valor de funcionamento: qualidade de vida, empoderamento invisível e resultados práticos de custo zero. Apresentamos uma nova forma de fazer menos e ganhar mais, despertando a tentativa de realizar o mínimo com o aprendizado computacional possível.",
            bulletPoints = listOf(
                "Inovação Furtiva: Ações mínimas práticas de baixo atrito.",
                "Qualidade de vida com empoderamento invisível sem confrontos.",
                "Transformação de descartes locais (como guarda-chuvas quebrados em capas/barracas).",
                "Mente computacional primária acima da subjetividade do condutor."
            ),
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuDoJJkdtfDXcCKzS_4h691fZXm0LeaQFzOgV9NUj8pG4--u4fRUg_-vktfV6tx8W2PRduvrkbMSdr1Px-U4wwH2AhjAS8Byaf5OTHO4fw8c-mQ4wXQ_TgetGpfo036QciBN1VXj86XlF7I2gz-qHDKPKG051ygMtZu0S5NIo1R1kfD9YKn22jBZrDs8yKBfeVt2Vr_-mXZhvEj83OtH0KLbCkqtqsQDPBE4B4ahTopjldOYxaxT19n6"
        ),
        BookSlide(
            id = "slide_2",
            title = "Rede Neural do Ecossistema",
            subtitle = "Arquitetura de Ingestão e Processamento da Borda à Nuvem",
            category = "Rede Neural",
            badge = "Arquitetura viva",
            narrationText = "A Rede Neural do Ecossistema O3BR mapeia os dados brutos da extremidade através das 5 Lentes da Espinha Dorsal: Potencial Invisível, Bifurcação de Valor, Inovação Furtiva, Estado de Fluir e Lei do Silêncio. Os dados passam pelo Sistema Imunológico com Desvio Preditivo para desviar de agentes impeditivos e acionar gatilhos no Google Cloud e Web3.",
            bulletPoints = listOf(
                "Camada de Entrada: Recursos descartados, sabedoria ancestral e dados ambientais/fauna.",
                "Espinha Dorsal (5 Lentes): Filtro de revalorização de custo zero e fluxo sem atrito.",
                "Sistema Imunológico: Desvio Preditivo para bypass de espectadores e sabotadores.",
                "Gatilhos de Ativação: Plus Codes, Firestore, Cloud Functions, Solana FVLA e MPEG-H."
            ),
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuC-t-PuD3qPWkjOaKgc9mZgrPoNrxUiiARdeVowlfJtTAPe2ybMrYPl7VhtEpahMfvAVXYr4qnvZAXoDig5XtWq5AnpoVzAddY9lwOp77pOVc_ug2T4a_C8Y1eJDHUUOsofmmeGfVtsXL2mt5bAyswFry2uYpKXVRhwcq0l6MeL0G1K13kI4K9qGrKy7WUsoS8xWUEEpXdmCX-153fH9WM4J345gSuuFuTTWYOxW7jxuqUfxvZ7W5lk"
        ),
        BookSlide(
            id = "slide_3",
            title = "Schedule Resource Engine",
            subtitle = "Interface Bento Grid de Gestão de Recursos e Pessoal",
            category = "Interface Bento Grid",
            badge = "Bento Live UI",
            narrationText = "Esta é a tela funcional de agendamento do O3BR Booking Engine. Ela exemplifica a aplicação do design system Dynamic Organism em uma interface de alta precisão em Dark Charcoal e Electric Cyan. Permite selecionar departamentos, cientistas responsáveis, calendários e horários com confirmação direta de transação segura no ecossistema.",
            bulletPoints = listOf(
                "Layout Bento Grid com painéis de vidro e brilho Aura Cyan.",
                "Seleção de departamento (Innovation Hub, Strategic Consulting, Creative Studio).",
                "Alocação de pessoal técnico (Dr. Aris Thorne e S. Lin).",
                "Módulo de horário GMT-4 em tempo real com código de sessão O3BR-9X-2A4."
            ),
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuBLCN-iiqxlWcRuhIZhDiNmTX4-qT0VDC9RC4C-3CFvsRFz039Z3uPmjkW8ArVqCuQhXI7taJzm53tmmOpmUdwMQV284T1KMardUjj8OmuxQZpn0fBmhB-gY687PHKYuZ-Cd2nYnC-QtALS84bMFDpmyjkYxWgi2XQ5MuFtJg3utqPHBLs1vV5TPFrg-00C1EpQiFgIosz1bE4lOR9Q5ICQtLvaksjGqRrZRmnHt-nqrjUvvy_cc56a"
        ),
        BookSlide(
            id = "slide_4",
            title = "Proposta GDG Santos & Caraguatatuba",
            subtitle = "Pitch Técnico de Dados na Extremidade usando Tecnologias Google",
            category = "Pitch GDG",
            badge = "Google Developers",
            narrationText = "Proposta de estudo de caso para o GDG Santos e GDG Caraguatatuba. Enquanto projetos tradicionais enfrentam a barreira de custos proibitivos de implantação, o O3BR demonstra como utilizar Google Plus Codes para geolocalização sem endereço formal, Firebase Firestore para ingestão leve, Gemini API para dados não-estruturados e Google Stax para validação contínua.",
            bulletPoints = listOf(
                "GDG Santos: Foco em infraestrutura urbana, reciclagem/upcycling inteligente e microeconomia.",
                "GDG Caraguatatuba: Foco em ecoturismo do Litoral Norte, birdwatching e mapeamento de fauna.",
                "Plus Codes: Mapeamento de precisão em áreas informais sem nomes de ruas.",
                "Contraste ETEC vs. O3BR: Solução de custo proibitivo vs. Ação mínima de custo zero."
            ),
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuCYjojQCVat1CFt_YnYiTIUl321Todz44oIw7_apGgj-ujTeiAfyMnusm9N5CUAOeUh3co0DUyrSbiKPnXKYWnFtkknKy3IOpBdXKCnOVtJsFjHO0grt-FQ-Q-1YXbgmUra7dpiEVoE_3UKp2M7Xo4WSIMNwg2OT2ODRk337OWf87gAr7SaPwA-6sKCsjxmHuqQq31tTX1pzBTEhoCnoHXzzXmqTh_3WEiz3BYq3bYlhkivpvJkA_Vc"
        ),
        BookSlide(
            id = "slide_5",
            title = "Ementa Pedagógica & Currículo",
            subtitle = "A Mente Computacional na Formação de Colaboradores de Escolas",
            category = "Ementa Maker",
            badge = "Plano Pedagógico",
            narrationText = "Apresentamos a Ementa Pedagógica para escolas inovadoras, ETECs e SESI. Baseada no trabalho de Ricardo Borges, ela coloca a Mente Computacional acima da individualidade do professor. Os alunos aprendem a enxergar valor em guarda-chuvas descartados para criar capas e barracas de camping, aplicando a Inovação Furtiva para contornar agentes impeditivos.",
            bulletPoints = listOf(
                "Unidade 1: Leitura do Potencial Invisível (Pensamento Maker Reverso).",
                "Unidade 2: Ações de Mínimo Custo e Mapeamento Digital via Plus Codes.",
                "Unidade 3: A Economia da Tradição e da Fauna Local.",
                "Unidade 4: Contorno de Obstáculos, Estado de Fluir e Ética do Silêncio."
            ),
            imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuDIeQJXT7qX00p7AVXZIwYV-8D6rQtai4dABmW8xoRKfrhVtDx_3boQJDvlwk3NMLxuBvXsvJ2nQs59sS_eV-dCGCxwBKDZXKUaNmog_Y1O0eNyJiLM0Rg5gx19UjYFtL0ooZqBSW22qS8hlA3B_ykJAI79HpQgww7NeryPY0L5b2dqW5eQjjO6uyXtvRpXQ4T6lQHWJbe8jB1zELnFbCe3snDEw5atgSh-eWUXX19aeDhWXLdKXBza"
        ),
        BookSlide(
            id = "slide_6",
            title = "Galeria de Imagens & Links HTML",
            subtitle = "Acesso Direto e Inserção de Links Externos de Imagens",
            category = "Galeria HTML",
            badge = "Live Links",
            narrationText = "Nesta seção você pode explorar todas as imagens HTML fornecidas, testar links diretos de imagens externas e adicioná-las dinamicamente ao book. Todos os ativos podem ser carregados via URL direta e copiados para integração em projetos e apresentações.",
            bulletPoints = listOf(
                "Carregamento em tempo real via Coil com suporte a URLs HTTPS.",
                "Visualizador em tela cheia com botão de cópia de código HTML <img>.",
                "Adição rápida de novas imagens com pré-visualização instantânea.",
                "Integração perfeita entre o ecossistema O3BR e a web global."
            )
        )
    )

    val neuralNodes: List<NeuralNode> = listOf(
        NeuralNode("n1", "ENTRADA", "Sensoriamento na Borda", "Captura de recursos descartados (madeiras, latas, guarda-chuvas) e sabedoria caiçara/ancestral.", "sensors"),
        NeuralNode("n2", "ENTRADA", "Plus Codes & Fauna", "Geolocalização de precisão sem CEP e registros de saruês, tejús e aves locais.", "pin_drop"),
        NeuralNode("n3", "LENTES", "5 Lentes da Espinha Dorsal", "Potencial Invisível, Bifurcação de Valor, Inovação Furtiva, Estado de Fluir e Lei do Silêncio.", "psychology"),
        NeuralNode("n4", "IMUNOLOGICO", "Desvio Preditivo", "Bypass automático de agentes impeditivos e sequestradores de fluxo antes que travem a ação.", "shield"),
        NeuralNode("n5", "IMUNOLOGICO", "Incubadora de Fluxo", "Aclimatação neutra do protótipo no ambiente físico sem necessidade de aprovações lentas.", "speed"),
        NeuralNode("n6", "GATILHOS", "Google Cloud Stack", "Firestore, Cloud Functions serverless e Gemini API estruturando áudios e textos.", "cloud"),
        NeuralNode("n7", "GATILHOS", "Web3 & MPEG-H", "Smart contracts na rede Solana (Token FVLA) e áudio imersivo MPEG-H para royalties.", "token"),
        NeuralNode("n8", "SAIDA", "Constrangimento Positivo", "Elevação do espaço urbano por contraste estético. O lixão dá lugar ao banco comunitário.", "auto_awesome")
    )
}
