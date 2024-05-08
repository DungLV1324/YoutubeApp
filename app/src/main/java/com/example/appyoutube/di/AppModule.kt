package com.example.appyoutube.di

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.appyoutube.data.repository.LanguageRepo
import com.example.appyoutube.data.repository.LanguageRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideSharedPreference(context: Application?): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
    @Provides
    @Singleton
    fun provideLanguage(application: Application): LanguageRepo {
        return LanguageRepoImpl(application)
    }
}