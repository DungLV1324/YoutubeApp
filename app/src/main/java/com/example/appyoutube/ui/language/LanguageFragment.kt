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

class LanguageFragment : BaseBindingFragment<FragmentLanguageBinding, LanguageVM>() {
    override fun getViewModel(): Class<LanguageVM> {
        return LanguageVM::class.java
    }

    private val languageAdapter: LanguageAdapter by lazy {
        LanguageAdapter().apply {

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

    private fun initData() {
        viewModel.getAllLanguage()
        viewModel.lisLanguageLiveDat.observeWithCatch(viewLifecycleOwner) {
            languageAdapter.submitList(it)
        }
    }

    private fun initAdapter() {
        binding.rcLanguage.adapter=languageAdapter

    }
}