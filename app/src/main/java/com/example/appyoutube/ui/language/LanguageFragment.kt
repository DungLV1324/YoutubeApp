package com.example.appyoutube.ui.language

import android.os.Bundle
import android.view.View
import com.example.appyoutube.R
import com.example.appyoutube.databinding.FragmentLanguageBinding
import com.example.appyoutube.ui.base.BaseBindingFragment

class LanguageFragment : BaseBindingFragment<FragmentLanguageBinding, LanguageVM>() {
    override fun getViewModel(): Class<LanguageVM> {
        return LanguageVM::class.java
    }

    override val layoutId: Int
        get() = R.layout.fragment_language

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        initAdapter()
        initData()
    }

    private fun initData() {

    }

    private fun initAdapter() {

    }
}