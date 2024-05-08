package com.example.appyoutube.data.repository

import com.example.appyoutube.data.model.Language
import kotlinx.coroutines.flow.Flow

interface LanguageRepo {
    fun getAllLanguage(): Flow<List<Language>>
}