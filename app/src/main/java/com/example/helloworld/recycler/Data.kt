package com.example.helloworld.recycler

import android.support.annotation.DrawableRes

data class Data(
        val title: String,
        val description: String,
        @DrawableRes val icon: Int? = null
)