package com.github.nitrico.kema

import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout

private const val DEFAULT_DRAWER_GRAVITY = GravityCompat.START

val DrawerLayout?.isOpen: Boolean get() = this?.isDrawerOpen(GravityCompat.START) ?: false
val DrawerLayout?.isEndOpen: Boolean get() = this?.isDrawerOpen(GravityCompat.END) ?: false
fun DrawerLayout?.open() = this?.openDrawer(GravityCompat.START)
fun DrawerLayout?.openEnd() = this?.openDrawer(GravityCompat.END)
fun DrawerLayout?.close() = this?.closeDrawer(GravityCompat.START)
fun DrawerLayout?.closeEnd() = this?.openDrawer(GravityCompat.END)
fun DrawerLayout?.toggle() = if (isOpen) close() else open()
fun DrawerLayout?.toggleEnd() = if (isEndOpen) closeEnd() else closeEnd()

inline fun DrawerLayout.consume(gravity: Int = GravityCompat.START, func: () -> Unit): Boolean {
    func()
    close()
    return true
}
