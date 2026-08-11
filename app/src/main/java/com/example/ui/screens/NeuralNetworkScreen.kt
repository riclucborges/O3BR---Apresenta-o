package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Token
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BookRepository
import com.example.model.NeuralNode
import com.example.ui.theme.O3brBrightCyan
import com.example.ui.theme.O3brElectricCyan

@Composable
fun NeuralNetworkScreen(
    onNavigateNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedNode by remember { mutableStateOf<NeuralNode?>(BookRepository.neuralNodes.first()) }
    var activeFilter by remember { mutableStateOf("TODAS") }

    val filteredNodes = remember(activeFilter) {
        if (activeFilter == "TODAS") BookRepository.neuralNodes
        else BookRepository.neuralNodes.filter { it.layer == activeFilter }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121414))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Title Header
        item {
            Column {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF003737))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "REDE NEURAL DO ECOSSISTEMA",
                        style = MaterialTheme.typography.labelSmall,
                        color = O3brBrightCyan,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Arquitetura de Dados na Extremidade",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = "Mapeamento dinâmico das camadas de ingestão, lentes da espinha dorsal, sistema imunológico e oráculos Google Cloud / Web3.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFB9CACA)
                )
            }
        }

        // Layer Filter Chips
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                val layers = listOf("TODAS", "ENTRADA", "LENTES", "IMUNOLOGICO", "GATILHOS", "SAIDA")
                layers.forEach { layer ->
                    val isSelected = activeFilter == layer
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (isSelected) O3brElectricCyan else Color(0xFF1E2020))
                            .border(1.dp, if (isSelected) O3brBrightCyan else Color(0xFF3A4A49), RoundedCornerShape(16.dp))
                            .clickable { activeFilter = layer }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = layer,
                            style = MaterialTheme.typography.labelSmall,
                            color = if (isSelected) Color(0xFF002020) else Color(0xFFB9CACA),
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }

        // Nodes Grid / List
        items(filteredNodes) { node ->
            val isSelected = selectedNode?.id == node.id
            NeuralNodeCard(
                node = node,
                isSelected = isSelected,
                onClick = { selectedNode = node }
            )
        }

        // Selected Node Details Box
        item {
            selectedNode?.let { node ->
                AnimatedVisibility(visible = true) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, O3brElectricCyan, RoundedCornerShape(12.dp)),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2020))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = null,
                                    tint = O3brElectricCyan,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "DETALHES DO NÓ: ${node.title.uppercase()}",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Camada: ${node.layer}",
                                style = MaterialTheme.typography.labelMedium,
                                color = O3brBrightCyan
                            )

                            Text(
                                text = node.description,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFFE2E2E2),
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            }
        }

        // Next Screen Button
        item {
            Button(
                onClick = onNavigateNext,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .testTag("navigate_to_schedule_button"),
                colors = ButtonDefaults.buttonColors(
                    containerColor = O3brElectricCyan,
                    contentColor = Color(0xFF002020)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "VER INTERFACE BENTO GRID (SCHEDULE) →",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun NeuralNodeCard(
    node: NeuralNode,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = if (isSelected) 2.dp else 1.dp,
                color = if (isSelected) O3brElectricCyan else Color(0xFF3A4A49),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFF1E2020) else Color(0xFF1A1C1C)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) O3brElectricCyan else Color(0xFF333535)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = getNodeIcon(node.iconName),
                    contentDescription = null,
                    tint = if (isSelected) Color(0xFF002020) else O3brElectricCyan,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = node.title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Camada ${node.layer}",
                    style = MaterialTheme.typography.labelSmall,
                    color = O3brElectricCyan,
                    fontSize = 11.sp
                )
            }
        }
    }
}

private fun getNodeIcon(name: String): ImageVector {
    return when (name) {
        "sensors" -> Icons.Default.Sensors
        "pin_drop" -> Icons.Default.PinDrop
        "psychology" -> Icons.Default.Psychology
        "shield" -> Icons.Default.Shield
        "speed" -> Icons.Default.Speed
        "cloud" -> Icons.Default.Cloud
        "token" -> Icons.Default.Token
        else -> Icons.Default.AutoAwesome
    }
}
