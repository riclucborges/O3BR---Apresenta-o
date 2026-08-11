package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material.icons.filled.Engineering
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.model.BookingState
import com.example.ui.theme.O3brBrightCyan
import com.example.ui.theme.O3brElectricCyan

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ScheduleResourceScreen(
    onNavigateNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    var state by remember { mutableStateOf(BookingState()) }
    val scrollState = rememberScrollState()

    val departments = listOf("Innovation Hub", "Strategic Consulting", "Creative Studio")
    val personnelList = listOf(
        Pair("Dr. A. Thorne", "Lead Scientist"),
        Pair("S. Lin", "Systems Arch")
    )
    val morningSlots = listOf("09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30 (Bloqueado)", "10:45")
    val afternoonSlots = listOf("13:00", "13:15", "13:30", "13:45", "14:00")

    val personnelAvatars = mapOf(
        "Dr. A. Thorne" to "https://lh3.googleusercontent.com/aida-public/AB6AXuBLCN-iiqxlWcRuhIZhDiNmTX4-qT0VDC9RC4C-3CFvsRFz039Z3uPmjkW8ArVqCuQhXI7taJzm53tmmOpmUdwMQV284T1KMardUjj8OmuxQZpn0fBmhB-gY687PHKYuZ-Cd2nYnC-QtALS84bMFDpmyjkYxWgi2XQ5MuFtJg3utqPHBLs1vV5TPFrg-00C1EpQiFgIosz1bE4lOR9Q5ICQtLvaksjGqRrZRmnHt-nqrjUvvy_cc56a",
        "S. Lin" to "https://lh3.googleusercontent.com/aida-public/AB6AXuCYjojQCVat1CFt_YnYiTIUl321Todz44oIw7_apGgj-ujTeiAfyMnusm9N5CUAOeUh3co0DUyrSbiKPnXKYWnFtkknKy3IOpBdXKCnOVtJsFjHO0grt-FQ-Q-1YXbgmUra7dpiEVoE_3UKp2M7Xo4WSIMNwg2OT2ODRk337OWf87gAr7SaPwA-6sKCsjxmHuqQq31tTX1pzBTEhoCnoHXzzXmqTh_3WEiz3BYq3bYlhkivpvJkA_Vc"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121414))
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Page Header
        Column {
            Text(
                text = "Schedule Resource",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Selecione o departamento, profissional e horário para confirmar o agendamento no O3BR.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFB9CACA),
                modifier = Modifier.padding(top = 2.dp)
            )
        }

        // Section 1 & 2: Department & Personnel Grid
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            // Department Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2020))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Domain,
                            contentDescription = null,
                            tint = O3brElectricCyan,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "DEPARTAMENTO",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = O3brElectricCyan,
                            letterSpacing = 1.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    departments.forEach { dept ->
                        val isSelected = state.selectedDepartment == dept
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isSelected) Color(0xFF003737) else Color(0xFF1A1C1C))
                                .border(1.dp, if (isSelected) O3brElectricCyan else Color(0xFF3A4A49), RoundedCornerShape(8.dp))
                                .clickable { state = state.copy(selectedDepartment = dept) }
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = when (dept) {
                                        "Innovation Hub" -> Icons.Default.Biotech
                                        "Strategic Consulting" -> Icons.Default.TrendingUp
                                        else -> Icons.Default.Brush
                                    },
                                    contentDescription = null,
                                    tint = if (isSelected) O3brBrightCyan else Color(0xFFB9CACA),
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = dept,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) Color.White else Color(0xFFE2E2E2)
                                )
                            }
                            RadioButton(
                                selected = isSelected,
                                onClick = { state = state.copy(selectedDepartment = dept) },
                                colors = RadioButtonDefaults.colors(selectedColor = O3brElectricCyan)
                            )
                        }
                    }
                }
            }

            // Personnel Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2020))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Engineering,
                            contentDescription = null,
                            tint = O3brElectricCyan,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "PESSOAL TÉCNICO",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = O3brElectricCyan,
                            letterSpacing = 1.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        personnelList.forEach { (name, role) ->
                            val isSelected = state.selectedPersonnel == name
                            val avatarUrl = personnelAvatars[name]

                            Card(
                                modifier = Modifier
                                    .weight(1f)
                                    .border(
                                        width = if (isSelected) 2.dp else 1.dp,
                                        color = if (isSelected) O3brElectricCyan else Color(0xFF3A4A49),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .clickable { state = state.copy(selectedPersonnel = name) },
                                colors = CardDefaults.cardColors(
                                    containerColor = if (isSelected) Color(0xFF003737) else Color(0xFF1A1C1C)
                                )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    avatarUrl?.let { url ->
                                        Box(
                                            modifier = Modifier
                                                .size(48.dp)
                                                .clip(CircleShape)
                                                .border(1.dp, O3brElectricCyan, CircleShape)
                                        ) {
                                            AsyncImage(
                                                model = url,
                                                contentDescription = name,
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier.fillMaxSize()
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        text = name,
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Text(
                                        text = role,
                                        style = MaterialTheme.typography.labelSmall,
                                        color = O3brBrightCyan,
                                        fontSize = 10.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Section 3: Time Slots Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2020))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Schedule,
                            contentDescription = null,
                            tint = O3brElectricCyan,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "HORÁRIOS DISPONÍVEIS",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = O3brElectricCyan,
                            letterSpacing = 1.sp
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF333535))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = "GMT-4 (EST)",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFFB9CACA),
                            fontSize = 10.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Manhã",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )

                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    morningSlots.forEach { slot ->
                        val cleanSlot = slot.split(" ").first()
                        val isLocked = slot.contains("Bloqueado")
                        val isSelected = state.selectedSlot == cleanSlot

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(
                                    if (isLocked) Color(0xFF121414)
                                    else if (isSelected) Color(0xFF003737)
                                    else Color(0xFF1A1C1C)
                                )
                                .border(
                                    width = if (isSelected) 2.dp else 1.dp,
                                    color = if (isLocked) Color(0xFF282A2B)
                                    else if (isSelected) O3brElectricCyan
                                    else Color(0xFF3A4A49),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clickable(enabled = !isLocked) {
                                    state = state.copy(selectedSlot = cleanSlot)
                                }
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = cleanSlot,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isLocked) Color.DarkGray else if (isSelected) O3brBrightCyan else Color.White
                                )
                                if (isLocked) {
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Icon(
                                        imageVector = Icons.Default.Lock,
                                        contentDescription = "Bloqueado",
                                        tint = Color.DarkGray,
                                        modifier = Modifier.size(12.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Tarde",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )

                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    afternoonSlots.forEach { slot ->
                        val isSelected = state.selectedSlot == slot

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(if (isSelected) Color(0xFF003737) else Color(0xFF1A1C1C))
                                .border(
                                    width = if (isSelected) 2.dp else 1.dp,
                                    color = if (isSelected) O3brElectricCyan else Color(0xFF3A4A49),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .clickable { state = state.copy(selectedSlot = slot) }
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = slot,
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) O3brBrightCyan else Color.White
                            )
                        }
                    }
                }
            }
        }

        // Booking Summary Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, O3brElectricCyan, RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E2020))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "BOOKING SUMMARY",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Serviço:", color = Color.Gray, style = MaterialTheme.typography.bodyMedium)
                    Text(text = state.selectedDepartment, color = O3brElectricCyan, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Pesquisador:", color = Color.Gray, style = MaterialTheme.typography.bodyMedium)
                    Text(text = state.selectedPersonnel, color = Color.White, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Data & Hora:", color = Color.Gray, style = MaterialTheme.typography.bodyMedium)
                    Text(text = "08/10/2024 às ${state.selectedSlot}", color = O3brBrightCyan, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "ID da Sessão:", color = Color.Gray, style = MaterialTheme.typography.bodyMedium)
                    Text(text = state.sessionId, color = Color.LightGray, style = MaterialTheme.typography.bodyMedium)
                }

                Spacer(modifier = Modifier.height(6.dp))

                Button(
                    onClick = { state = state.copy(isConfirmed = true) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("confirm_booking_button"),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (state.isConfirmed) Color(0xFF004F4F) else O3brElectricCyan,
                        contentColor = if (state.isConfirmed) O3brBrightCyan else Color(0xFF002020)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = if (state.isConfirmed) Icons.Default.Check else Icons.Default.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (state.isConfirmed) "AGENDAMENTO CONFIRMADO!" else "CONFIRMAR AGENDAMENTO",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                AnimatedVisibility(visible = state.isConfirmed) {
                    Text(
                        text = "🔒 Transação Segura Confirmada no Ecossistema O3BR",
                        style = MaterialTheme.typography.labelSmall,
                        color = O3brBrightCyan,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp)
                    )
                }
            }
        }

        // Navigate Next
        Button(
            onClick = onNavigateNext,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .testTag("navigate_to_gdg_button"),
            colors = ButtonDefaults.buttonColors(
                containerColor = O3brElectricCyan,
                contentColor = Color(0xFF002020)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "VER PITCH GDG SANTOS & CARAGUATATUBA →",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
