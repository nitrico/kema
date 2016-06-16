package com.github.nitrico.kema

import android.app.Activity
import android.app.ActivityManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.support.annotation.AnimRes
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.customtabs.CustomTabsIntent
import android.view.View
import android.view.WindowManager

fun Activity.setFullScreenLayout(@ColorInt statusBarColor: Int = Color.parseColor("#20000000")) {
    if (Build.VERSION.SDK_INT >= 19) {
        window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        // unset translucent status for Lollipop or higher so status bar color can be modified
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = statusBarColor
        }
    }
}

fun Activity.setTaskDescription(@DrawableRes iconRes: Int? = null,
                                @ColorInt color: Int = primaryColor,
                                title: String? = null) {
    if (Build.VERSION.SDK_INT >= 21) {
        if (iconRes != null) {
            val bitmap = BitmapFactory.decodeResource(resources, iconRes)
            setTaskDescription(ActivityManager.TaskDescription(title, bitmap, color))
            bitmap.recycle()
        }
        else setTaskDescription(ActivityManager.TaskDescription(title, null, color))
    }
}

fun Activity.openCustomTab(url: String,
                           @ColorInt color: Int = Color.WHITE,
                           showTitle: Boolean = true,
                           @AnimRes animStartEnter: Int = android.R.anim.slide_in_left,
                           @AnimRes animStartExit: Int = android.R.anim.slide_out_right,
                           @AnimRes animExitEnter: Int = android.R.anim.slide_in_left,
                           @AnimRes animExitExit: Int = android.R.anim.slide_out_right
) = CustomTabsIntent.Builder()
        .setShowTitle(showTitle)
        .setToolbarColor(color)
        .setStartAnimations(this, animStartEnter, animStartExit)
        .setExitAnimations(this, animExitEnter, animExitExit)
        .build()
        .launchUrl(this, Uri.parse(url))
