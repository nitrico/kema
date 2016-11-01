package com.github.nitrico.kema

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewConfiguration

fun View.setLightStatusBar(condition: Boolean = true) {
    if (Build.VERSION.SDK_INT >= 23 && condition) {
        systemUiVisibility = systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}

/**
 * Return true if the navigation bar is on the screen (the device doesn't have physical buttons),
 * false otherwise
 */
val Context.hasNavigationBar: Boolean
    get() {
        if (Build.VERSION.SDK_INT < 19) return false
        return !ViewConfiguration.get(this).hasPermanentMenuKey()
    }

/**
 * Return true if navigation bar is at the bottom, false otherwise
 */
val Context.isNavigationBarHorizontal: Boolean
    get() {
        if (!hasNavigationBar) return false
        val dm = resources.displayMetrics
        return !navigationBarCanChangeItsPosition || dm.widthPixels < dm.heightPixels
    }

/**
 * Return true if navigation bar change its position when device rotates, false otherwise
 */
val Context.navigationBarCanChangeItsPosition: Boolean // Only phone between 0-599dp can
    get() {
        val dm = resources.displayMetrics
        return dm.widthPixels != dm.heightPixels && resources.configuration.smallestScreenWidthDp < 600
    }

/**
 * When using KitKat or higher, return the status bar height. 0 otherwise
 */
val Context.statusBarHeight: Int
    get() {
        if (Build.VERSION.SDK_INT < 19) return 0
        val id = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(id)
    }

/**
 * When using KitKat or higher and the navigation bar is at the bottom, return its height. 0 otherwise
 */
val Context.navigationBarHeight: Int
    get() {
        if (!hasNavigationBar) return 0
        if (navigationBarCanChangeItsPosition && !isPortrait()) return 0
        val idString = if (isPortrait()) "navigation_bar_height" else "navigation_bar_height_landscape"
        val id = resources.getIdentifier(idString, "dimen", "android")
        if (id > 0) return resources.getDimensionPixelSize(id)
        return 0
    }

/**
 * When using KitKat or higher and the navigation bar is on the right, return its width. 0 otherwise
 */
val Context.navigationBarWidth: Int
    get() {
        if (!hasNavigationBar) return 0
        if (navigationBarCanChangeItsPosition && !isPortrait()) {
            val id = resources.getIdentifier("navigation_bar_width", "dimen", "android")
            if (id > 0) return resources.getDimensionPixelSize(id)
        }
        return 0
    }
