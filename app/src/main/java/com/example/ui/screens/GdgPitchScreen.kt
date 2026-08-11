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
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DeveloperBoard
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Psychology
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
fun GdgPitchScreen(
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
                text = "PITCH GOOGLE DEVELOPER GROUPS (GDG)",
                style = MaterialTheme.typography.labelSmall,
                color = O3brBrightCyan,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp
            )
        }

        Text(
            text = "GDG Santos & GDG Caraguatatuba",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "Como apresentar o O3BR aos capítulos do GDG como um benchmark de computação de borda, dados em tempo real e ecossistema sem atrito financeiro.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFB9CACA)
        )

        // Comparison Card: ETEC vs O3BR
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, O3brElectricCyan, RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2020))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "PARADOXO ETEC VS. LÓGICA O3BR",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = O3brElectricCyan
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Traditional Column
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(8.dp)),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1C1C))
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "TRADICIONAL / ETEC",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.Red,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text("• Custo Proibitivo", color = Color.Gray, fontSize = 12.sp)
                            Text("• Dependência de Aportes", color = Color.Gray, fontSize = 12.sp)
                            Text("• Atrito com Impeditivos", color = Color.Gray, fontSize = 12.sp)
                            Text("• Teoria sem Execução", color = Color.Gray, fontSize = 12.sp)
                        }
                    }

                    // O3BR Column
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .border(1.dp, O3brBrightCyan, RoundedCornerShape(8.dp)),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF003737))
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "INOVAÇÃO FURTIVA O3BR",
                                style = MaterialTheme.typography.labelSmall,
                                color = O3brBrightCyan,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text("• Custo Zero de Entrada", color = Color.White, fontSize = 12.sp)
                            Text("• Ativos de Descarte", color = Color.White, fontSize = 12.sp)
                            Text("• Desvio Preditivo", color = Color.White, fontSize = 12.sp)
                            Text("• Estado de Fluir Instantâneo", color = Color.White, fontSize = 12.sp)
                        }
                    }
                }
            }
        }

        // Google Stack Highlights
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1C1C))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "PILHA DE TECNOLOGIAS GOOGLE UTILIZADA",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                GdgTechRow(
                    icon = Icons.Default.Map,
                    title = "Google Plus Codes",
                    description = "Indexação de geolocalização de precisão em áreas informais sem nomes de ruas."
                )

                GdgTechRow(
                    icon = Icons.Default.DeveloperBoard,
                    title = "Firebase & Cloud Functions",
                    description = "Ingestão serverless de ultra-baixa latência e custo zero para a extremidade."
                )

                GdgTechRow(
                    icon = Icons.Default.Psychology,
                    title = "Gemini API & NotebookLM",
                    description = "Transformação de relatos orais em dados estruturados e resumos pedagógicos."
                )

                GdgTechRow(
                    icon = Icons.Default.Code,
                    title = "Google Stax",
                    description = "Avaliação contínua de prompts e respostas de IA com dados reais de campo."
                )
            }
        }

        // Chapters focus
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2020))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "FOCO REGIONAL DE APRESENTAÇÃO",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = O3brElectricCyan
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "• GDG Santos: Focado em upcycling urbano, reciclagem de baixo atrito, cidades inteligentes e microeconomia local no Litoral Sul.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFE2E2E2)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "• GDG Caraguatatuba: Focado em ecotrilhas, geolocalização de fauna (saruê, tejú, aves), observação de pássaros e monetização de dados de preservação no Litoral Norte.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFE2E2E2)
                )
            }
        }

        // Navigate Button
        Button(
            onClick = onNavigateNext,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .testTag("navigate_to_curriculum_button"),
            colors = ButtonDefaults.buttonColors(
                containerColor = O3brElectricCyan,
                contentColor = Color(0xFF002020)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "VER EMENTA PEDAGÓGICA (RICARDO BORGES) →",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun GdgTechRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String
) {
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
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = O3brBrightCyan,
                modifier = Modifier.size(18.dp)
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
                text = description,
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFFB9CACA)
            )
        }
    }
}
