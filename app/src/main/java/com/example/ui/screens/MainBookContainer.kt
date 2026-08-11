package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DeveloperMode
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BookRepository
import com.example.narration.NarrationManager
import com.example.ui.components.O3brTopBar
import com.example.ui.theme.O3brBrightCyan
import com.example.ui.theme.O3brElectricCyan

@Composable
fun MainBookContainer() {
    val context = LocalContext.current
    val narrationManager = remember { NarrationManager(context) }

    var currentSlideIndex by remember { mutableIntStateOf(0) }
    val isSpeaking by narrationManager.isSpeaking.collectAsState()
    val speechRate by narrationManager.speechRate.collectAsState()
    val statusMessage by narrationManager.statusMessage.collectAsState()

    val slides = BookRepository.slides
    val currentSlide = slides[currentSlideIndex]

    DisposableEffect(Unit) {
        onDispose {
            narrationManager.shutdown()
        }
    }

    Scaffold(
        topBar = {
            O3brTopBar(
                currentSlideIndex = currentSlideIndex,
                totalSlides = slides.size,
                isSpeaking = isSpeaking,
                speechRate = speechRate,
                statusText = statusMessage,
                onTogglePlay = {
                    if (isSpeaking) {
                        narrationManager.pauseOrStop()
                    } else {
                        narrationManager.speak(currentSlide.narrationText)
                    }
                },
                onChangeSpeed = { rate ->
                    narrationManager.setSpeed(rate)
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF121414),
                contentColor = O3brElectricCyan,
                modifier = Modifier.border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            ) {
                val navItems = listOf(
                    Triple("Geral", Icons.Default.Home, "nav_geral"),
                    Triple("Rede Neural", Icons.Default.Psychology, "nav_rede"),
                    Triple("Schedule", Icons.Default.CalendarMonth, "nav_schedule"),
                    Triple("Pitch GDG", Icons.Default.DeveloperMode, "nav_gdg"),
                    Triple("Ementa", Icons.Default.School, "nav_ementa"),
                    Triple("Galeria", Icons.Default.Image, "nav_galeria")
                )

                navItems.forEachIndexed { index, (label, icon, tag) ->
                    val isSelected = currentSlideIndex == index
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            currentSlideIndex = index
                            narrationManager.stop()
                        },
                        icon = {
                            Icon(
                                imageVector = icon,
                                contentDescription = label,
                                tint = if (isSelected) O3brBrightCyan else Color.Gray
                            )
                        },
                        label = {
                            Text(
                                text = label,
                                style = MaterialTheme.typography.labelSmall,
                                fontSize = 9.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) O3brBrightCyan else Color.Gray
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color(0xFF003737)
                        ),
                        modifier = Modifier.testTag(tag)
                    )
                }
            }
        },
        containerColor = Color(0xFF121414)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentSlideIndex) {
                0 -> SlideOverviewScreen(
                    slide = currentSlide,
                    isSpeaking = isSpeaking,
                    onSpeakNarration = {
                        if (isSpeaking) narrationManager.pauseOrStop()
                        else narrationManager.speak(currentSlide.narrationText)
                    },
                    onNavigateNext = {
                        currentSlideIndex = 1
                        narrationManager.stop()
                    }
                )
                1 -> NeuralNetworkScreen(
                    onNavigateNext = {
                        currentSlideIndex = 2
                        narrationManager.stop()
                    }
                )
                2 -> ScheduleResourceScreen(
                    onNavigateNext = {
                        currentSlideIndex = 3
                        narrationManager.stop()
                    }
                )
                3 -> GdgPitchScreen(
                    onNavigateNext = {
                        currentSlideIndex = 4
                        narrationManager.stop()
                    }
                )
                4 -> PedagogicalCurriculumScreen(
                    onNavigateNext = {
                        currentSlideIndex = 5
                        narrationManager.stop()
                    }
                )
                5 -> HtmlImageGalleryScreen()
            }
        }
    }
}
