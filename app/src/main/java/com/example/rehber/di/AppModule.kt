package com.example.rehber.di

import android.content.Context
import androidx.room.Room
import com.example.rehber.repo.PersoneDao
import com.example.rehber.room.Database
import com.example.rehber.room.PersonroomDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton // Birkere oluşturulan ve heryerden erişime açılan yapıyı temsil eder.
    fun providePersondao(pdao:PersonroomDao):PersoneDao{
        return PersoneDao(pdao)
    }

    @Provides
    @Singleton // Birkere oluşturulan ve heryerden erişime açılan yapıyı temsil eder.
    fun providePersondao2(@ApplicationContext context:Context):PersonroomDao{
        val dt = Room.databaseBuilder(context.applicationContext,Database::class.java,"rehber.sqlite").fallbackToDestructiveMigration().build()
        return dt.getPersoneDao()
    }
}