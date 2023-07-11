package com.example.movieapp.presentation.di

import com.example.movieapp.App
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
//@Component(modules = [
//    AppModule::class,
//    CacheDataModule::class,
//    DatabaseInstance::class,
//    RemoteDataModule::class,
//    LocalDataModule::class,
//    RepositoryModule::class,
//    RetrofitInstance::class,
//    UseCaseModule::class
//])

@InstallIn(SingletonComponent::class)
interface AppComponent {
@Binds
    fun movieSubComponentFactory(factory: MovieSubComponent.Factory): MovieSubComponent.Factory

}