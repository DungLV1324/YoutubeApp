package com.example.appyoutube.ui.language

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appyoutube.data.model.Language
import com.example.appyoutube.data.repository.LanguageRepo
import com.example.appyoutube.ui.base.BaseViewModel
import com.example.appyoutube.ui.base.toMutableList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LanguageVM @Inject constructor(
    private var languageRepo: LanguageRepo
) : BaseViewModel() {
    private var _lisLanguageLiveDat: MutableLiveData<List<Language>> = MutableLiveData()
    val lisLanguageLiveDat: MutableLiveData<List<Language>>
        get() = _lisLanguageLiveDat

    private fun getValueLanguage() = _lisLanguageLiveDat.toMutableList { it.copy() }
    fun getAllLanguage() {
        viewModelScope.launch(Dispatchers.IO) {
            languageRepo.getAllLanguage()
                .flowOn(Dispatchers.IO)
                .collectLatest { language ->
                    _lisLanguageLiveDat.postValue(language)
                }
        }
    }


}