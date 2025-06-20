package com.example.notesync.data.mapper

import com.example.notesync.data.local.NoteEntity
import com.example.notesync.data.remote.NoteDto
import com.example.notesync.domain.model.Note

fun NoteEntity.toDomain() : Note {
    return Note(id = this.id, title = this.title, body = this.body)
}

fun Note.toNoteEntity() : NoteEntity {
    return NoteEntity(id = this.id, title = this.title, body = this.body)
}

fun NoteDto.toNoteEntity(): NoteEntity {
    return NoteEntity(id = this.id, title = this.title, body = this.body)
}
