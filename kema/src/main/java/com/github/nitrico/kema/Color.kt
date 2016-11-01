package com.github.nitrico.kema

import android.content.Context
import android.graphics.Color
import android.support.annotation.ColorInt

val Context.colorAccent: Int
    @ColorInt get() = resolve(R.attr.colorAccent)

val Context.colorPrimary: Int
    @ColorInt get() = resolve(R.attr.colorPrimary)

val Context.colorPrimaryDark: Int
    @ColorInt get() = resolve(R.attr.colorPrimaryDark)

val String.asColor: Int @ColorInt get() = Color.parseColor(this)

@ColorInt fun blendColors(@ColorInt color1: Int, @ColorInt color2: Int, ratio: Float): Int {
    val inverseRation = 1 - ratio;
    val a = Color.alpha(color1) * ratio + Color.alpha(color2) * inverseRation
    val r = Color.red  (color1) * ratio + Color.red  (color2) * inverseRation
    val g = Color.green(color1) * ratio + Color.green(color2) * inverseRation
    val b = Color.blue (color1) * ratio + Color.blue (color2) * inverseRation
    return Color.argb(a.toInt(), r.toInt(), g.toInt(), b.toInt())
}

fun Int.tween(end: Int, t: Float): Int {
    val red = Color.red(this).tween(Color.red(end), t)
    val green = Color.green(this).tween(Color.green(end), t)
    val blue = Color.blue(this).tween(Color.blue(end), t)
    val alpha = Color.alpha(this).tween(Color.alpha(end), t)
    return Color.argb(alpha, red, green, blue)
}
