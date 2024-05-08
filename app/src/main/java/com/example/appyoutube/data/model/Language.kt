package com.example.appyoutube.data.model

import android.graphics.drawable.Drawable

data class Language
    (
    var name: String?,
    var code: String?,
    var image: Drawable? = null,
    var isSelect: Boolean = false
)