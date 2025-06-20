package com.example.notesync.ui.screen

import com.example.notesync.domain.model.Note

data class NoteUiState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
