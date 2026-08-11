package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Link
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.example.ui.theme.O3brBrightCyan
import com.example.ui.theme.O3brElectricCyan

data class HtmlImageItem(
    val title: String,
    val url: String,
    val description: String
)

@Composable
fun HtmlImageGalleryScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val imageList = remember {
        mutableStateListOf(
            HtmlImageItem(
                title = "O3BR Ecosystem Header",
                url = "https://lh3.googleusercontent.com/aida-public/AB6AXuDoJJkdtfDXcCKzS_4h691fZXm0LeaQFzOgV9NUj8pG4--u4fRUg_-vktfV6tx8W2PRduvrkbMSdr1Px-U4wwH2AhjAS8Byaf5OTHO4fw8c-mQ4wXQ_TgetGpfo036QciBN1VXj86XlF7I2gz-qHDKPKG051ygMtZu0S5NIo1R1kfD9YKn22jBZrDs8yKBfeVt2Vr_-mXZhvEj83OtH0KLbCkqtqsQDPBE4B4ahTopjldOYxaxT19n6",
                description = "Logo e Emblema principal do Ecossistema O3BR"
            ),
            HtmlImageItem(
                title = "Dr. Aris Thorne Avatar",
                url = "https://lh3.googleusercontent.com/aida-public/AB6AXuBLCN-iiqxlWcRuhIZhDiNmTX4-qT0VDC9RC4C-3CFvsRFz039Z3uPmjkW8ArVqCuQhXI7taJzm53tmmOpmUdwMQV284T1KMardUjj8OmuxQZpn0fBmhB-gY687PHKYuZ-Cd2nYnC-QtALS84bMFDpmyjkYxWgi2XQ5MuFtJg3utqPHBLs1vV5TPFrg-00C1EpQiFgIosz1bE4lOR9Q5ICQtLvaksjGqRrZRmnHt-nqrjUvvy_cc56a",
                description = "Retrato do Lead Scientist no ecossistema"
            ),
            HtmlImageItem(
                title = "S. Lin Systems Arch",
                url = "https://lh3.googleusercontent.com/aida-public/AB6AXuCYjojQCVat1CFt_YnYiTIUl321Todz44oIw7_apGgj-ujTeiAfyMnusm9N5CUAOeUh3co0DUyrSbiKPnXKYWnFtkknKy3IOpBdXKCnOVtJsFjHO0grt-FQ-Q-1YXbgmUra7dpiEVoE_3UKp2M7Xo4WSIMNwg2OT2ODRk337OWf87gAr7SaPwA-6sKCsjxmHuqQq31tTX1pzBTEhoCnoHXzzXmqTh_3WEiz3BYq3bYlhkivpvJkA_Vc",
                description = "Retrato do Arquiteto de Sistemas O3BR"
            ),
            HtmlImageItem(
                title = "O3BR System Core Node",
                url = "https://lh3.googleusercontent.com/aida-public/AB6AXuC-t-PuD3qPWkjOaKgc9mZgrPoNrxUiiARdeVowlfJtTAPe2ybMrYPl7VhtEpahMfvAVXYr4qnvZAXoDig5XtWq5AnpoVzAddY9lwOp77pOVc_ug2T4a_C8Y1eJDHUUOsofmmeGfVtsXL2mt5bAyswFry2uYpKXVRhwcq0l6MeL0G1K13kI4K9qGrKy7WUsoS8xWUEEpXdmCX-153fH9WM4J345gSuuFuTTWYOxW7jxuqUfxvZ7W5lk",
                description = "Ícone de Nó do Sistema e Inteligência de Borda"
            )
        )
    }

    var newUrlInput by remember { mutableStateOf("") }
    var newTitleInput by remember { mutableStateOf("") }
    var selectedPreviewImage by remember { mutableStateOf<HtmlImageItem?>(null) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121414))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF003737))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "GALERIA DE IMAGENS & LINKS HTML",
                    style = MaterialTheme.typography.labelSmall,
                    color = O3brBrightCyan,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Indexador de Links Diretos de Imagens",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Sim! É totalmente possível carregar e integrar links diretos de imagens HTML no app. Você pode visualizar, copiar e adicionar novos links dinamicamente.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFB9CACA)
            )
        }

        // Add Custom Image URL Form Card
        item {
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
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Link,
                            contentDescription = null,
                            tint = O3brElectricCyan,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "ADICIONAR NOVO LINK DE IMAGEM HTML",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    OutlinedTextField(
                        value = newTitleInput,
                        onValueChange = { newTitleInput = it },
                        label = { Text("Título da Imagem") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = O3brElectricCyan,
                            unfocusedBorderColor = Color(0xFF3A4A49),
                            focusedLabelColor = O3brElectricCyan,
                            unfocusedLabelColor = Color.Gray,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("add_image_title_input")
                    )

                    OutlinedTextField(
                        value = newUrlInput,
                        onValueChange = { newUrlInput = it },
                        label = { Text("URL Direta da Imagem (https://...)") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = O3brElectricCyan,
                            unfocusedBorderColor = Color(0xFF3A4A49),
                            focusedLabelColor = O3brElectricCyan,
                            unfocusedLabelColor = Color.Gray,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("add_image_url_input")
                    )

                    Button(
                        onClick = {
                            if (newUrlInput.isNotBlank()) {
                                val title = if (newTitleInput.isNotBlank()) newTitleInput else "Imagem Personalizada O3BR"
                                imageList.add(
                                    HtmlImageItem(
                                        title = title,
                                        url = newUrlInput.trim(),
                                        description = "Link de imagem externa adicionado pelo usuário"
                                    )
                                )
                                Toast.makeText(context, "Link de imagem adicionado!", Toast.LENGTH_SHORT).show()
                                newUrlInput = ""
                                newTitleInput = ""
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("add_image_submit_button"),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = O3brElectricCyan,
                            contentColor = Color(0xFF002020)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(text = "INSERIR IMAGEM NO BOOK", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Image List Items
        items(imageList) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(12.dp))
                    .clickable { selectedPreviewImage = item },
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1C1C))
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF121414))
                            .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(8.dp))
                    ) {
                        AsyncImage(
                            model = item.url,
                            contentDescription = item.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = item.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFFB9CACA)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = item.url,
                            style = MaterialTheme.typography.labelSmall,
                            color = O3brElectricCyan,
                            maxLines = 1,
                            modifier = Modifier.weight(1f)
                        )

                        IconButton(
                            onClick = {
                                val htmlTag = "<img src=\"${item.url}\" alt=\"${item.title}\" />"
                                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                val clip = ClipData.newPlainText("O3BR HTML Tag", htmlTag)
                                clipboard.setPrimaryClip(clip)
                                Toast.makeText(context, "Código HTML <img> copiado!", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.ContentCopy,
                                contentDescription = "Copiar HTML",
                                tint = O3brBrightCyan,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    // Modal Fullscreen Preview
    selectedPreviewImage?.let { item ->
        Dialog(onDismissRequest = { selectedPreviewImage = null }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(2.dp, O3brElectricCyan, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF121414))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )

                        IconButton(onClick = { selectedPreviewImage = null }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "Fechar", tint = Color.White)
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(1.dp, Color(0xFF3A4A49), RoundedCornerShape(12.dp))
                    ) {
                        AsyncImage(
                            model = item.url,
                            contentDescription = item.title,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Código HTML pronto para inserção:",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Gray
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF1E2020))
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "<img src=\"${item.url}\" alt=\"${item.title}\" />",
                            style = MaterialTheme.typography.labelSmall,
                            color = O3brBrightCyan,
                            fontSize = 11.sp
                        )
                    }
                }
            }
        }
    }
}
