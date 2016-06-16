package com.github.nitrico.kema

import android.os.Build
import android.support.annotation.ColorInt
import android.support.v4.widget.NestedScrollView
import android.widget.AbsListView
import android.widget.EdgeEffect
import android.widget.ScrollView

fun AbsListView.setEdgeEffectColor(@ColorInt color: Int) {
    if (Build.VERSION.SDK_INT >= 21) {
        val edgeEffect = EdgeEffect(context).apply { this.color = color }
        javaClass.getDeclaredField("mEdgeGlowTop").apply {
            isAccessible = true
            set(this@setEdgeEffectColor, edgeEffect)
        }
        javaClass.getDeclaredField("mEdgeGlowBottom").apply {
            isAccessible = true
            set(this@setEdgeEffectColor, edgeEffect)
        }
    }
}

fun ScrollView.setEdgeEffectColor(@ColorInt color: Int) {
    if (Build.VERSION.SDK_INT >= 21) {
        val edgeEffect = EdgeEffect(context).apply { this.color = color }
        javaClass.getDeclaredField("mEdgeGlowTop").apply {
            isAccessible = true
            set(this@setEdgeEffectColor, edgeEffect)
        }
        javaClass.getDeclaredField("mEdgeGlowBottom").apply {
            isAccessible = true
            set(this@setEdgeEffectColor, edgeEffect)
        }
    }
}

fun NestedScrollView.setEdgeEffectColor(@ColorInt color: Int) {
    if (Build.VERSION.SDK_INT >= 21) {
        val edgeEffect = EdgeEffect(context).apply { this.color = color }
        javaClass.getDeclaredField("mEdgeGlowTop").apply {
            isAccessible = true
            set(this@setEdgeEffectColor, edgeEffect)
        }
        javaClass.getDeclaredField("mEdgeGlowBottom").apply {
            isAccessible = true
            set(this@setEdgeEffectColor, edgeEffect)
        }
    }
}
