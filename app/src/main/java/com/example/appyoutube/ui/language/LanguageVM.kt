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
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LanguageVM @Inject constructor(
    private var languageRepo: LanguageRepo) : BaseViewModel() {

    private var _listLanguageLiveData: MutableLiveData<List<Language>> = MutableLiveData()
    val lisLanguageLiveData: MutableLiveData<List<Language>>
        get() = _listLanguageLiveData

    private fun getValueLanguage() = _listLanguageLiveData.toMutableList { it.copy() }
    fun getAllLanguage() {
        viewModelScope.launch(Dispatchers.IO) {
            languageRepo.getAllLanguage()
                .collectLatest { language ->
                    _listLanguageLiveData.postValue(language)
                }
        }
    }

    fun updateSelectOneView(pos: Int) =
        viewModelScope.launch(Dispatchers.IO) {
            getValueLanguage().let { temp ->
                temp.let {
                    for (i in it.indices) {
                        it[i].isSelect = (i == pos)
                        _listLanguageLiveData.postValue(it)
                    }
                }
            }
        }

}