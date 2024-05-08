package com.example.appyoutube.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.appyoutube.R
import com.example.appyoutube.databinding.ActivityMainBinding
import com.example.appyoutube.ui.base.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding, MainVM>() {
    private val navHostFragment :NavHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment }
    val navController : NavController by lazy { navHostFragment.navController }
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun getViewModel(): Class<MainVM> {
        return MainVM::class.java
    }

    override fun setupView(savedInstanceState: Bundle?) {

    }

    override fun setupData() {
    }
}