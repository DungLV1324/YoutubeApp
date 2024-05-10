package com.example.appyoutube.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.appyoutube.R
import com.example.appyoutube.databinding.FragmentHomeBinding
import com.example.appyoutube.databinding.FragmentLanguageBinding
import com.example.appyoutube.ui.adapter.LanguageAdapter
import com.example.appyoutube.ui.base.BaseBindingFragment
import com.example.appyoutube.ui.base.observeWithCatch
import com.example.appyoutube.ui.permission.PermissionFragment
import com.example.appyoutube.utils.extention.setOnSafeClick
import timber.log.Timber

class HomeFragment : BaseBindingFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    private val languageAdapter: LanguageAdapter by lazy {
        LanguageAdapter().apply {

        }
    }
    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAdapter()
        initData()
        onClick()
    }

    private fun onClick() {

    }

    private fun initAdapter() {
//        binding.rcLanguage.adapter = languageAdapter
    }

    private fun initData() {
//        viewModel.lisLanguageLiveData.observeWithCatch(viewLifecycleOwner) {
//            languageAdapter.submitList(it)
//        }
    }
}