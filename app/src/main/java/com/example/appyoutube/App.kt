package com.example.appyoutube

import android.app.Application
import android.content.SharedPreferences
import com.example.appyoutube.utils.MyDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var sharedPreferenceHelper: SharedPreferences

    companion object {
        lateinit var instance: App

    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        initLog()
    }

    private fun initLog() {
//        if (BuildConfig.DEBUG) {
        Timber.plant(MyDebugTree())
    }

}