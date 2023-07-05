package com.example.notetakingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notetakingapp.database.NoteDAO
import com.example.notetakingapp.model.Note
import com.example.notetakingapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application, private val repository: NoteRepository) :
    AndroidViewModel(app) {

//    private val _notesLiveData = MutableLiveData<List<Note>>()
//    val notesLiveData: LiveData<List<Note>>
//        get() = _notesLiveData

    // above code can be use in many cases but i don't use it here


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
    fun getAllNotes() : LiveData<List<Note>> {
        return repository.getAllNotes()
    }

    fun searchNote(query: String?): LiveData<List<Note>> {
        return repository.searchNote(query = query)
    }


}