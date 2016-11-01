package com.github.nitrico.kema

import android.os.Build
import android.support.annotation.ColorInt
import android.support.v4.widget.EdgeEffectCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView

fun RecyclerView.smoothScrollTo(position: Int, callback: (() -> Unit)? = null) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                callback?.invoke()
                removeOnScrollListener(this)
            }
        }
    })
    smoothScrollToPosition(position)
}

fun GridLayoutManager.setSpanSize(func: (Int) -> Int) {
    spanSizeLookup = object: GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int) = func(position)
    }
}

fun RecyclerView.setEdgeEffectColor(@ColorInt color: Int) {
    if (Build.VERSION.SDK_INT >= 21) {
        val edgeEffect = EdgeEffectCompat(context)
        javaClass.getDeclaredField("mTopGlow").apply {
            isAccessible = true
            set(this@setEdgeEffectColor, edgeEffect)
        }
        javaClass.getDeclaredField("mBottomGlow").apply {
            isAccessible = true
            set(this@setEdgeEffectColor, edgeEffect)
        }
        javaClass.getDeclaredField("mLeftGlow").apply {
            isAccessible = true
            set(this@setEdgeEffectColor, edgeEffect)
        }
        javaClass.getDeclaredField("mRightGlow").apply {
            isAccessible = true
            set(this@setEdgeEffectColor, edgeEffect)
        }
    }
}
