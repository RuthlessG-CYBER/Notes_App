package com.example.notesapp


import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteCard(navController: NavController, onSaveNote: (Note) -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd yyyy"))

    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize().align(Alignment.CenterStart).padding(top = 10.dp, bottom = 10.dp)
            ) {
                Box(modifier = Modifier.fillMaxWidth().height(35.dp).padding(start = 10.dp, end = 10.dp)) {
                    Row {
                        Icon(
                            Icons.Default.KeyboardArrowLeft, contentDescription = "",
                            modifier = Modifier.size(35.dp).clickable { navController.navigate("NoteApp") }
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            Icons.Default.Check, contentDescription = "",
                            modifier = Modifier.size(30.dp).clickable {
                                val note = Note(title, description, currentDate)
                                onSaveNote(note)
                                navController.navigate("NoteApp")
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                Box(modifier = Modifier) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
                            .background(Color.Transparent)
                    ) {
                        if (title.isEmpty()) {
                            Text(
                                text = "Title",
                                fontSize = 25.sp,
                                color = Color.Black
                            )
                        }
                        BasicTextField(
                            value = title,
                            onValueChange = { title = it },
                            textStyle = TextStyle(fontSize = 22.sp, color = Color.Black)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

                Box(modifier = Modifier) {
                    Text(
                        text = currentDate,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(start = 15.dp, end = 15.dp),
                        letterSpacing = TextUnit.Unspecified,
                        fontStyle = FontStyle.Italic
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp)
                        .background(Color.Transparent)
                ) {
                    if (description.isEmpty()) {
                        Text(
                            text = "Description",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
                    BasicTextField(
                        value = description,
                        onValueChange = { description = it },
                        textStyle = TextStyle(fontSize = 16.sp, color = Color.Black)
                    )
                }
            }
        }
    }
}