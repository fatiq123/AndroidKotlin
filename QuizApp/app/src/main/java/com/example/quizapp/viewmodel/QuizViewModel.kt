package com.example.quizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.model.Question
import com.example.quizapp.model.QuestionsList
import com.example.quizapp.repository.QuizRepository

class QuizViewModel : ViewModel() {

    private val repository: QuizRepository = QuizRepository()

    private val questionsLiveData: LiveData<QuestionsList>

    init {
        questionsLiveData = repository.getQuestionsFromAPI()
    }

    fun getQuestionsFromLiveData(): LiveData<QuestionsList> {
        return questionsLiveData
    }
}