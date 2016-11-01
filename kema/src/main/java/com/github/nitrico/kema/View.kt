package com.github.nitrico.kema

import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.LayoutRes
import android.support.v4.view.ViewCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver

val View.res: Resources get() = resources
val View.ctx: Context get() = context

fun View.show() { visibility = View.VISIBLE }
fun View.hide() { visibility = View.GONE }

fun View.showIf(condition: Boolean) = if (condition) show() else hide()

fun View.setPaddingStart(paddingStart: Int) = ViewCompat.setPaddingRelative(this,
        paddingStart,
        paddingTop,
        ViewCompat.getPaddingEnd(this),
        paddingBottom)

fun View.setPaddingTop(paddingTop: Int) = ViewCompat.setPaddingRelative(this,
        ViewCompat.getPaddingStart(this),
        paddingTop,
        ViewCompat.getPaddingEnd(this),
        paddingBottom)

fun View.setPaddingEnd(paddingEnd: Int) = ViewCompat.setPaddingRelative(this,
        ViewCompat.getPaddingStart(this),
        paddingTop,
        paddingEnd,
        paddingBottom)

fun View.setPaddingBottom(paddingBottom: Int) = ViewCompat.setPaddingRelative(this,
        ViewCompat.getPaddingStart(this),
        paddingTop,
        ViewCompat.getPaddingEnd(this),
        paddingBottom)

fun View.elevate(elevation: Float) {
    if (Build.VERSION.SDK_INT >= 21) setElevation(elevation)
    else ViewCompat.setElevation(this, elevation)
}

fun View.elevate(elevation: Int) = elevate(elevation.toFloat())

fun View.isAttachedToWindow(): Boolean {
    if (Build.VERSION.SDK_INT >= 19) return isAttachedToWindow
    else return ViewCompat.isAttachedToWindow(this)
}

fun View.isInBounds(container: View): Boolean {
    val containerBounds = Rect()
    container.getHitRect(containerBounds)
    return getLocalVisibleRect(containerBounds)
}

inline fun <T : View> T.onClick(crossinline func: T.() -> Unit) {
    setOnClickListener { func() }
}

inline fun <T : View> T.onLongClick(crossinline func: T.() -> Unit) {
    setOnLongClickListener { func(); true }
}

inline fun <T : View> T.onGlobalLayout(crossinline func: T.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                func()
            }
        }
    })
}

inline fun <T : View> T.onPreDraw(crossinline func: T.() -> Unit) {
    viewTreeObserver.addOnPreDrawListener(object: ViewTreeObserver.OnPreDrawListener {
        override fun onPreDraw(): Boolean {
            viewTreeObserver.removeOnPreDrawListener(this)
            func()
            return true
        }
    })
}

fun View.setHeight(height: Int) {
    if (layoutParams is ViewGroup.LayoutParams) {
        val params = layoutParams
        params.height = height
        requestLayout()
    }
}

var View.heightDp: Int
    get() = height.dp
    set(value) = setHeight(value.dp)

fun View.setMargins(l: Int, t: Int, r: Int, b: Int) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        val params = layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(l, t, r, b)
        requestLayout()
    }
}

fun View.setMarginsDp(l: Int, t: Int, r: Int, b: Int) = setMargins(l.dp, t.dp, r.dp, b.dp)

fun View.setPaddingDp(l: Int, t: Int, r: Int, b: Int) = setPadding(l.dp, t.dp, r.dp, b.dp)

fun View.changeBackgroundColor(@ColorInt newColor: Int, duration: Int = 300) {
    val oldBackground = background
    val color = ColorDrawable(newColor)
    val ld = LayerDrawable(arrayOf<Drawable>(color))
    if (oldBackground == null) background = ld
    else {
        val td = TransitionDrawable(arrayOf(oldBackground, ld))
        background = td
        td.startTransition(duration)
    }
}

val ViewGroup.children: List<View>
    get() = (0..childCount-1).map { getChildAt(it) }

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
