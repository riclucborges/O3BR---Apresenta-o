package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
fun O3brTopBar(
    currentSlideIndex: Int,
    totalSlides: Int,
    isSpeaking: Boolean,
    speechRate: Float,
    statusText: String,
    onTogglePlay: () -> Unit,
    onChangeSpeed: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color(0xFF121414),
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Logo & App Name
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF1E2020))
                            .border(1.dp, O3brElectricCyan, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "O3BR",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = O3brElectricCyan,
                            fontSize = 10.sp
                        )
                    }

                    Column {
                        Text(
                            text = "O3BR BOOK",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Tela ${currentSlideIndex + 1} de $totalSlides • Narração PT-BR",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFFB9CACA),
                            fontSize = 11.sp
                        )
                    }
                }

                // Narration Play/Pause Control
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // Speed selector chip
                    SpeedChip(
                        currentRate = speechRate,
                        onSelectRate = onChangeSpeed
                    )

                    // Main play/pause button
                    IconButton(
                        onClick = onTogglePlay,
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(if (isSpeaking) O3brBrightCyan else O3brElectricCyan)
                            .testTag("narration_toggle_button")
                    ) {
                        Icon(
                            imageVector = if (isSpeaking) Icons.Default.Pause else Icons.Default.VolumeUp,
                            contentDescription = if (isSpeaking) "Pausar Narração" else "Ouvir Narração em Português",
                            tint = Color(0xFF002020)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Audio Visualizer bar
            AudioWaveVisualizer(isSpeaking = isSpeaking)
        }
    }
}

@Composable
private fun SpeedChip(
    currentRate: Float,
    onSelectRate: (Float) -> Unit
) {
    val rates = listOf(0.8f, 1.0f, 1.25f, 1.5f)
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF1E2020))
            .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(20.dp))
            .padding(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        rates.forEach { rate ->
            val isSelected = rate == currentRate
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(if (isSelected) O3brElectricCyan else Color.Transparent)
                    .clickable { onSelectRate(rate) }
                    .padding(horizontal = 6.dp, vertical = 3.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${rate}x",
                    style = MaterialTheme.typography.labelSmall,
                    color = if (isSelected) Color(0xFF002020) else Color(0xFFB9CACA),
                    fontSize = 10.sp,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                )
            }
        }
    }
}
