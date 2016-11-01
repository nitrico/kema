package com.github.nitrico.kema

import android.app.Activity
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.MenuRes
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu

operator fun Menu.get(id: Int) = findItem(id)

val Menu.items: List<MenuItem>
    get() = (0..size()-1).map { getItem(it) }

inline fun Menu.forEach(func: (item: MenuItem) -> Unit) { for (i in 0..size()-1) func(getItem(i)) }

fun Menu.tint(@ColorInt color: Int = Color.WHITE) = forEach { it.icon?.tint = color }

fun Activity.inflate(@MenuRes menuId: Int, menu: Menu): Boolean {
    menuInflater.inflate(menuId, menu)
    return true
}

fun Activity.inflateMenuFile(@MenuRes menuRes: Int): List<MenuItem> {
    val popup = PopupMenu(this, null)
    val menu = popup.menu
    menuInflater.inflate(menuRes, menu)
    return menu.items
}
