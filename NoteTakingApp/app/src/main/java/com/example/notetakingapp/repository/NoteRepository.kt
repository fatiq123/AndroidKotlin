package com.example.notetakingapp.repository

import androidx.room.Query
import com.example.notetakingapp.database.NoteDAO
import com.example.notetakingapp.database.NoteDatabase
import com.example.notetakingapp.model.Note

class NoteRepository(private val db: NoteDatabase) {

    suspend fun insertNote(note: Note) {
        db.getNodeDao().insertNote(note = note)
    }

    suspend fun updateNote(note: Note) {
        db.getNodeDao().updateNote(note = note)
    }

    suspend fun deleteNote(note: Note) {
        db.getNodeDao().deleteNote(note = note)
    }

    fun getAllNotes() {
        db.getNodeDao().getAllNotes()
    }

    fun searchNote(query: String?) {
        db.getNodeDao().searchNote(query = query)
    }

}