package com.example.movieapp.presentation.di

import dagger.Component
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DatabaseInstance::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    RepositoryModule::class,
    RetrofitInstance::class,
    UseCaseModule::class
])
@InstallIn(ActivityComponent::class)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
}