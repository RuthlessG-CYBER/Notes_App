package com.example.notesapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppNavigation()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesAppNavigation() {
    val navController = rememberNavController()
    val notes = remember { mutableStateListOf<com.example.notesapp.Note>() }

    NavHost(navController = navController, startDestination = "NoteApp") {
        composable("NoteApp") {
            NoteApp(navController, notes, onAddNote = {
                navController.navigate("NoteCard")
            })
        }
        composable("NoteCard") {
            NoteCard(navController, onSaveNote = { note ->
                notes.add(note)
            })
        }
    }
}