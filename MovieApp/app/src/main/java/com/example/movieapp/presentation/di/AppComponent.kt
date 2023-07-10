package com.example.movieapp.presentation.di

import dagger.Component
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
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
}