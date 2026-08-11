package com.example.model

data class BookSlide(
    val id: String,
    val title: String,
    val subtitle: String,
    val category: String,
    val narrationText: String,
    val bulletPoints: List<String>,
    val imageUrl: String? = null,
    val badge: String? = null
)

data class NeuralNode(
    val id: String,
    val layer: String, // "ENTRADA", "LENTES", "IMUNOLOGICO", "GATILHOS", "SAIDA"
    val title: String,
    val description: String,
    val iconName: String,
    val isActive: Boolean = true
)

data class BookingState(
    val selectedDepartment: String = "Innovation Hub",
    val selectedPersonnel: String = "Dr. A. Thorne",
    val selectedDate: String = "08/10/2024",
    val selectedSlot: String = "09:30",
    val isConfirmed: Boolean = false,
    val sessionId: String = "O3BR-9X-2A4"
)
