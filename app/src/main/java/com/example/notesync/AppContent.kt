package com.example.notesync

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.notesync.data.local.LocalDatabaseProvider
import com.example.notesync.data.remote.RetroFitClient
import com.example.notesync.data.repository.NoteRepository
import com.example.notesync.ui.screen.NoteScreen
import com.example.notesync.ui.screen.NoteViewModel

@Composable
fun AppContent(context: Context) {
    val noteDao = remember { LocalDatabaseProvider.getDatabase(context).noteDao() }
    val noteApi = remember { RetroFitClient.api }
    val repository = remember { NoteRepository(noteDao, noteApi) }
    val viewModel = remember { NoteViewModel(repository) }
    NoteScreen(viewModel)
}