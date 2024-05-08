package com.example.appyoutube.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        LocaleUtils.applyLocale(requireContext())
        super.onCreate(savedInstanceState)
    }
}