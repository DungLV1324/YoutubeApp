package com.example.appyoutube.utils.extention

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat

fun Context.isGrantPermission(permission: String): Boolean {
    val isGrant = ContextCompat.checkSelfPermission(
        this, permission
    )
    return isGrant == PackageManager.PERMISSION_GRANTED
}


fun Context.isGrantAudioPermission() {
    if (isAtLeastSdkVersion(33)){
        isGrantPermission(Manifest.permission.READ_MEDIA_AUDIO)
    } else {
        isGrantPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
    }
}

fun Context.isGrantNotificationPermission() =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        isGrantPermission(Manifest.permission.POST_NOTIFICATIONS)
    } else {
        true
    }
