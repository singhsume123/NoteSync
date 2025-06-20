package com.example.notesync.data.remote

import retrofit2.http.GET


interface NoteApi {
    @GET("posts")
    suspend fun getNotes(): List<NoteDto>
}