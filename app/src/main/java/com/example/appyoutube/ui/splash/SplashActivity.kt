package com.example.appyoutube.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.appyoutube.databinding.ActivitySplashBinding
import com.example.appyoutube.ui.MainVM
import com.example.appyoutube.ui.base.BaseBindingActivity
import com.example.appyoutube.R
import com.example.appyoutube.ui.MainActivity
import com.example.appyoutube.ui.language.LanguageFragment
import com.example.appyoutube.ui.permission.PermissionFragment
import com.example.appyoutube.ui.permission.PermissionVM
import com.example.appyoutube.utils.extention.gone
import com.example.appyoutube.utils.extention.invisible
import com.example.appyoutube.utils.extention.setStatusBarColor
import com.example.appyoutube.utils.extention.visible
import com.example.appyoutube.utils.setLightStatusBars
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseBindingActivity<ActivitySplashBinding,MainVM>(){
    override val layoutId: Int
        get() = R.layout.activity_splash

    override fun getViewModel(): Class<MainVM> {
        return MainVM::class.java
    }

    override fun setupView(savedInstanceState: Bundle?) {
        window.setLightStatusBars(true)
        setStatusBarColor("#ffffff")
        start()
    }

    private fun startToPermission() {
        runCatching {
            Intent(this@SplashActivity,PermissionFragment::class.java).apply {
                startActivity(this)
            }
        }.onFailure { it.printStackTrace() }
    }

    private fun startToLanguage() {
        runCatching {
            Intent(this@SplashActivity,LanguageFragment::class.java).apply {
                startActivity(this)
            }
        }.onFailure { it.printStackTrace() }
    }

    private fun startToMain() {
        runCatching {
            Intent(this@SplashActivity,MainActivity::class.java).apply {
                startActivity(this)

            }
        }.onFailure { it.printStackTrace() }
    }

    private fun start() {
        lifecycleScope.launch (Dispatchers.Main){
            delay(3000)
            binding.image.invisible()
            binding.animationView.visible()
            delay(1000)
            startToMain()
        }

    }

    override fun setupData() {
    }
}