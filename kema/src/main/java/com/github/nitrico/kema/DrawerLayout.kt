package com.github.nitrico.kema

import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout

private const val DEFAULT_DRAWER_GRAVITY = GravityCompat.START

val DrawerLayout?.isOpen: Boolean get() = this?.isDrawerOpen(DEFAULT_DRAWER_GRAVITY) ?: false
fun DrawerLayout?.open() = this?.openDrawer(DEFAULT_DRAWER_GRAVITY)
fun DrawerLayout?.close() = this?.closeDrawer(DEFAULT_DRAWER_GRAVITY)
fun DrawerLayout?.toggle() = if (isOpen) close() else open()

inline fun DrawerLayout.consume(func: () -> Unit): Boolean {
    func()
    close()
    return true
}
