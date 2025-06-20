package com.example.notesync.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesync.data.repository.NoteRepository
import com.example.notesync.domain.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NoteViewModel(private val noteRepository: NoteRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(NoteUiState())
    val uiState: StateFlow<NoteUiState> = _uiState.asStateFlow()
    init {
        observeNotes()
        syncNotesFromRemote()
    }
    private fun observeNotes() {
        viewModelScope.launch {
            noteRepository.notes.collect { notes ->
                _uiState.update { it.copy(notes = notes, isLoading = false, errorMessage = null) }
            }

        }
    }

    fun addNote(title: String, body: String) {
        viewModelScope.launch {
            noteRepository.insertNote(
                Note(
                    id = 0,
                    title = title,
                    body = body
                )
            )
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }

    fun syncNotesFromRemote() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                noteRepository.fetchRemoteNotes()
                _uiState.update { it.copy(isLoading = false, errorMessage = null) }

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = e.message ?: "Unknown Error"
                    )
                }
            }
        }
    }
}