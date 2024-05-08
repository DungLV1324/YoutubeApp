package com.example.appyoutube.ui.permission

import android.os.Bundle
import android.view.View
import com.example.appyoutube.R
import com.example.appyoutube.databinding.FragmentLanguageBinding
import com.example.appyoutube.databinding.FragmentPermissionBinding
import com.example.appyoutube.ui.base.BaseBindingFragment

class PermissionFragment : BaseBindingFragment<FragmentPermissionBinding,PermissionVM>(){
    override fun getViewModel(): Class<PermissionVM> {
        return PermissionVM::class.java
    }

    override val layoutId: Int
        get() = R.layout.fragment_permission

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
    }
}