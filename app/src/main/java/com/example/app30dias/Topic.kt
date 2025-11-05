package com.example.app30dias

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    val idea: String,
    @DrawableRes val jpeg: Int,
    val description: String
)