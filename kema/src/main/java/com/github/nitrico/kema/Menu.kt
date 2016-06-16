package com.github.nitrico.kema

import android.app.Activity
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.MenuRes
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu

operator fun Menu.get(index: Int) = getItem(index)

val Menu.items: List<MenuItem>
    get() {
        val items = mutableListOf<MenuItem>()
        forEach { items.add(it) }
        return items
    }

fun Menu.forEach(func: (item: MenuItem) -> Unit) { for (i in 0..size()-1) func(get(i)) }

fun Menu.tint(@ColorInt color: Int = Color.WHITE) = forEach { it.icon?.tint = color }

fun Activity.inflate(@MenuRes menuId: Int, menu: Menu): Boolean {
    menuInflater.inflate(menuId, menu)
    return true
}

fun Activity.inflateMenu(@MenuRes menuRes: Int): List<MenuItem> {
    val popup = PopupMenu(this, null)
    val menu = popup.menu
    menuInflater.inflate(menuRes, menu)
    val items = mutableListOf<MenuItem>()
    for (i in 0..menu.size()-1) items.add(menu.getItem(i))
    return items
}
