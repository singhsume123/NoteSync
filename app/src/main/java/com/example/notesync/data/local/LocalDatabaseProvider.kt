package com.example.notesync.data.local

import android.content.Context
import androidx.room.Room

object LocalDatabaseProvider {
    @Volatile
    private var INSTANCE: NoteDataBase? = null

    fun getDatabase(context: Context): NoteDataBase {
        return INSTANCE ?: synchronized(this) {
            Room.databaseBuilder(
                context.applicationContext, NoteDataBase::class.java, "note_database"
            ).build().also { INSTANCE = it }

        }
    }
}