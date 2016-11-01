package com.github.nitrico.kema

import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup

// region SnackBar

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG, f: (Snackbar.() -> Unit)? = null) {
    val snack = Snackbar.make(this, message, length)
    if (f != null) snack.f()
    snack.show()
}

fun Snackbar.action(action: String, @ColorInt color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}

// endregion SnackBar


// region TabLayout

operator fun TabLayout.get(position: Int): TabLayout.Tab = getTabAt(position)!!

inline fun TabLayout.forEach(func: (TabLayout.Tab) -> Unit) {
    for (i in 0..tabCount-1) func(get(i))
}

fun TabLayout.tint(selectedPosition: Int = 0,
                   selectedColor: Int = ContextCompat.getColor(context, android.R.color.white),
                   defaultColor: Int = Color.parseColor("#80FFFFFF")) {
    forEach { it.icon?.tint = defaultColor }
    get(selectedPosition).icon?.tint = selectedColor
}

fun TabLayout.hideTitles() = forEach {
    it.contentDescription = it.text
    it.text = ""
}

fun TabLayout.setIcons(icons: List<Drawable>) {
    for (i in 0..tabCount-1) get(i).icon = icons[i]
    tint()
}

fun TabLayout.setIcons(@DrawableRes icons: Array<Int>) {
    for (i in 0..tabCount-1) get(i).icon = ContextCompat.getDrawable(context, icons[i])
    tint()
}

fun TabLayout.setIcons(icons: TypedArray) {
    for (i in 0..tabCount-1) get(i).icon = icons.getDrawable(i)
    tint()
}

fun TabLayout.getTabViewAt(position: Int) = (getChildAt(0) as ViewGroup).getChildAt(position)

// endregion TabLayout
