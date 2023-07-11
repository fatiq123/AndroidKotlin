package com.example.quizapp.retrofit

import com.example.quizapp.model.QuestionsListItem
import retrofit2.Response
import retrofit2.http.GET

interface QuestionsApi {

    @GET("questionsapi.php")
    suspend fun getQuestions(): Response<QuestionsListItem>
}