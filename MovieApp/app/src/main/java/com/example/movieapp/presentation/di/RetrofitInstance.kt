package com.example.movieapp.presentation.di

import com.example.movieapp.data.api.TMDBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton
@InstallIn(ActivityComponent::class)
@Module
class RetrofitInstance(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {       // retrofit instance but in separate file
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }
}