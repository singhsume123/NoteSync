package com.example.notesync.data.repository

import com.example.notesync.data.local.NoteDao
import com.example.notesync.data.mapper.toDomain
import com.example.notesync.data.mapper.toNoteEntity
import com.example.notesync.data.remote.NoteApi
import com.example.notesync.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepository(private val noteDao  : NoteDao, private val noteApi : NoteApi) {

    val notes : Flow<List<Note>> = noteDao.getAllNotes()
        .map { list -> list.map { it.toDomain() } }

    suspend fun insertNote(note : Note) {
        noteDao.insertNote(note.toNoteEntity())
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }

    suspend fun fetchRemoteNotes() {
        val remoteNotes = noteApi.getNotes()
        val entities = remoteNotes.map { it.toNoteEntity() }
        entities.forEach { noteDao.insertNote(it) }
    }
}