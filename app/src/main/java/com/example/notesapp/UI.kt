package com.example.notesapp

import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


data class Note(val title: String, val description: String, val date: String)

@Composable
fun NoteApp(navController: NavController, notes: List<Note>, onAddNote: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Card(
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                )
            ) {
                Row {
                    Card(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = "Notes App",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(10.dp)
                                .drawBehind {
                                    drawContext.canvas.nativeCanvas.apply {
                                        drawText(
                                            "Notes App",
                                            0f,
                                            100f, // Adjust as per need
                                            android.graphics.Paint().apply {
                                                color = android.graphics.Color.GRAY // Shadow color
                                                textSize = 40.sp.toPx()
                                                setShadowLayer(10f, 5f, 5f, android.graphics.Color.DKGRAY)
                                            }
                                        )
                                    }
                                }
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(35.dp).align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            Icons.Default.MoreVert,
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(notes) { note ->
                    NoteItem(note = note)
                }
            }
        }

        Card(
            modifier = Modifier
                .height(90.dp).width(90.dp)
                .align(Alignment.BottomEnd)
                .padding(bottom = 20.dp, end = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0x80808080)
            ),
            shape = RoundedCornerShape(30.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                FloatingActionButton(
                    onClick = onAddNote,
                    containerColor = Color(0xFF000000),
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add Note",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun NoteItem(note: Note) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Column(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)) {
            Text(text = note.title, fontSize = 20.sp, fontWeight = FontWeight.Bold, overflow = TextOverflow.Ellipsis, maxLines = 1, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = note.date, fontSize = 10.sp, fontStyle = FontStyle.Italic)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = note.description, fontSize = 15.sp, fontStyle = FontStyle.Normal, overflow = TextOverflow.Ellipsis, maxLines = 1)
        }
    }
}