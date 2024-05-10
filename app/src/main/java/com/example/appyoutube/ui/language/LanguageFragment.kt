package com.example.appyoutube.ui.language

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.appyoutube.R
import com.example.appyoutube.databinding.FragmentLanguageBinding
import com.example.appyoutube.ui.adapter.LanguageAdapter
import com.example.appyoutube.ui.base.BaseBindingFragment
import com.example.appyoutube.ui.base.observeWithCatch
import com.example.appyoutube.ui.permission.PermissionFragment
import com.example.appyoutube.utils.extention.setOnSafeClick
import timber.log.Timber

class LanguageFragment : BaseBindingFragment<FragmentLanguageBinding, LanguageVM>() {
    private var currentLanguage = "en"
    private var oldLanguage = "en"
    override fun getViewModel(): Class<LanguageVM> {
        return LanguageVM::class.java
    }

    private val languageAdapter: LanguageAdapter by lazy {
        LanguageAdapter().apply {
            iClickItem = { language, pos ->
                language.code?.let {
                    viewModel.updateSelectOneView(pos)
                    currentLanguage = language.code ?: currentLanguage
                }
            }
        }
    }
    override val layoutId: Int
        get() = R.layout.fragment_language

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAdapter()
        initData()
        onClick()
    }

    private fun onClick() {
        binding.tvDone.setOnSafeClick {
            navigateFragment(R.id.fragment_permission)
        }
    }

    private fun initAdapter() {
        binding.rcLanguage.adapter = languageAdapter
    }

    private fun initData() {
        currentLanguage = oldLanguage
        viewModel.getAllLanguage()
        viewModel.lisLanguageLiveData.observeWithCatch(viewLifecycleOwner) {
            languageAdapter.submitList(it)
        }
    }
}