package com.example.notetakingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notetakingapp.model.Note
import com.example.notetakingapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private val repository: NoteRepository) :
    AndroidViewModel(app) {

    fun insertNote(note: Note) {
        viewModelScope.launch {
            repository.insertNote(note = note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            repository.updateNote(note = note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note = note)
        }
    }

    // because these are normal functions so I should not use coroutine with them
    fun getAllNotes() {
        repository.getAllNotes()
    }

    fun searchNote(query: String?) {
        repository.searchNote(query = query)
    }


}