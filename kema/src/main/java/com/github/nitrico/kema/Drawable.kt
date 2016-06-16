package com.github.nitrico.kema

import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorInt
import android.support.v4.graphics.drawable.DrawableCompat

var Drawable.tint: Int
    @ColorInt get() = tint
    @ColorInt set(value) {
        if (Build.VERSION.SDK_INT >= 21) setTint(value)
        else DrawableCompat.setTint(DrawableCompat.wrap(this), value)
    }
