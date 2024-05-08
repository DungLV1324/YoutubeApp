package com.example.appyoutube.ui.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        this.setLocale()
        super.onCreate(savedInstanceState)
    }

    override fun attachBaseContext(newBase: Context) {
//        newBase.setLocale()
        super.attachBaseContext(newBase)
    }
}