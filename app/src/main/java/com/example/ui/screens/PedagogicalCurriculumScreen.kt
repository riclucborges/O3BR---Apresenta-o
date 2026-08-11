package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Class
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Umbrella
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.O3brBrightCyan
import com.example.ui.theme.O3brElectricCyan

@Composable
fun PedagogicalCurriculumScreen(
    onNavigateNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121414))
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Badge Header
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF003737))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                text = "CURRÍCULO PROFISSIONAL DE RICARDO BORGES",
                style = MaterialTheme.typography.labelSmall,
                color = O3brBrightCyan,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp
            )
        }

        Text(
            text = "Ementa Pedagógica para Escolas Inovadoras",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "Engenharia de Fluxo e Inovação Furtiva de Custo Zero para Escolas Técnicas, ETECs, SESI e instituições de ensino de alto potencial.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFB9CACA)
        )

        // Premise Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, O3brElectricCyan, RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2020))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Psychology,
                        contentDescription = null,
                        tint = O3brElectricCyan,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "A MENTE COMPUTACIONAL SOBRE O PROFESSOR",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = O3brBrightCyan
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "A aplicação pedagógica frequentemente falha porque depende da subjetividade do condutor. Quando desenhamos a aprendizagem como um algoritmo de baixo atrito, o resultado passa a ser um resultado sistêmico inevitável.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFE2E2E2)
                )
            }
        }

        // Maker Examples Card (Guarda-chuvas -> Capas)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1C1C))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Umbrella,
                        contentDescription = null,
                        tint = O3brElectricCyan,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "EXEMPLOS PRÁTICOS DE REVALORIZAÇÃO DE CUSTO ZERO",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "• Guarda-chuvas Quebrados → Capas de Chuva Impermeáveis & Barracas de Camping",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = O3brBrightCyan
                )

                Text(
                    text = "• Camas e Estrados Descartados → Bancos Pivotantes de Descanso Comunitário",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = O3brBrightCyan,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = "• Sobras de Fibra Óptica Abandona → Estrutura de Fixação de Alta Resistência",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = O3brBrightCyan,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        // 4 Units Breakdown
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2020))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "PLANO DE ENSINO EM 4 UNIDADES",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = O3brElectricCyan
                )

                UnitRow(num = "U1", title = "Potencial Invisível & Pensamento Maker Reverso", desc = "Identificação de ativos de custo zero no entorno imediato.")
                UnitRow(num = "U2", title = "Ações Mínimas & Mapeamento via Plus Codes", desc = "Geolocalização digital e documentação leve no Google Cloud.")
                UnitRow(num = "U3", title = "Economia da Tradição e Mapeamento de Fauna", desc = "Valorização do saber dos anciãos e catálogo biológico regional.")
                UnitRow(num = "U4", title = "Inovação Furtiva & Ética do Silêncio", desc = "Contorno de agentes impeditivos com entregas práticas no Estado de Fluir.")
            }
        }

        // Navigate Button
        Button(
            onClick = onNavigateNext,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .testTag("navigate_to_gallery_button"),
            colors = ButtonDefaults.buttonColors(
                containerColor = O3brElectricCyan,
                contentColor = Color(0xFF002020)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "VER GALERIA DE IMAGENS HTML & LINKS DIRETO →",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun UnitRow(num: String, title: String, desc: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFF003737)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = num,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = O3brBrightCyan
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = desc,
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFFB9CACA)
            )
        }
    }
}
