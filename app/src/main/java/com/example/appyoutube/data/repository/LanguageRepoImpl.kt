package com.example.appyoutube.data.repository

import android.app.Application
import com.example.appyoutube.R
import com.example.appyoutube.data.model.Language
import com.example.appyoutube.utils.LanguageUtils.getPreLanguage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class LanguageRepoImpl @Inject constructor(private val application: Application) : LanguageRepo {
    override fun getAllLanguage(): Flow<List<Language>> {
        return flow {

            try {
                val listLanguage = mutableListOf<Language>()
                val listName = listOf(
                    R.string.english,
                    R.string.france,
                    R.string.india,
                    R.string.portuguese,
                    R.string.spanish,
                    R.string.vietnam
                )
                val listImage = listOf(
                    R.drawable.ic_nc_anh,
                    R.drawable.ic_france,
                    R.drawable.ic_india,
                    R.drawable.ic_portugal,
                    R.drawable.ic_spain,
                    R.drawable.ic_vietnam
                )
                val listCodes: List<String> = listOf(
                    "en",
                    "fr",
                    "hi",
                    "pt",
                    "es",
                    "vi"
                )

                for (i in listImage.indices) {
                    Language(
                        name = application.getString(listName[i]),
                        code = listCodes[i],
                        application.getDrawable(listImage[i])
                    ).apply {
                        listLanguage.add(this)
//                        listLanguage.firstOrNull { it.code == getPreLanguage() }?.let {
//                            it.isSelect = true
//                        }
                        emit(listLanguage)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                emit(mutableListOf())

            }
        }
    }
}