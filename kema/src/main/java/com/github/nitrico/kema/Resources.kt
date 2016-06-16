package com.github.nitrico.kema

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.v4.content.ContextCompat

fun Context.boolRes(@BoolRes id: Int): Boolean = resources.getBoolean(id)
fun Context.dimenRes(@DimenRes id: Int): Float = resources.getDimension(id)
fun Context.stringRes(@StringRes id: Int): String = getString(id)

@ColorInt fun Context.colorRes(@ColorRes id: Int) = ContextCompat.getColor(this, id)
fun Context.colorStateListRes(@ColorRes id: Int) = ContextCompat.getColor(this, id)
fun Context.drawableRes(@DrawableRes id: Int) = ContextCompat.getDrawable(this, id)

fun Context.colorStateListsFromArrayRes(@ArrayRes id: Int): List<ColorStateList> {
    val array = resources.obtainTypedArray(id)
    val list = mutableListOf<ColorStateList>()
    for (i in 0..array.length()-1) list.add(array.getColorStateList(i))
    array.recycle()
    return list
}

fun Context.drawablesFromArrayRes(@ArrayRes id: Int): List<Drawable> {
    val array = resources.obtainTypedArray(id)
    val list = mutableListOf<Drawable>()
    for (i in 0..array.length()-1) list.add(array.getDrawable(i))
    array.recycle()
    return list
}

fun Context.intArrayRes(@ArrayRes arrayResId: Int): Lazy<List<Int>>
        = lazy { resources.getIntArray(arrayResId).toList() }

fun Context.stringArrayRes(@ArrayRes arrayResId: Int): Lazy<List<String>>
        = lazy { resources.getStringArray(arrayResId).toList() }

fun Context.drawableArrayRes(@ArrayRes arrayResId: Int): Lazy<List<Drawable>>
        = lazy { drawablesFromArrayRes(arrayResId) }

fun Context.colorStateListArrayRes(@ArrayRes arrayResId: Int): Lazy<List<ColorStateList>>
        = lazy { colorStateListsFromArrayRes(arrayResId) }

val Int.asBool: Boolean @BoolRes get() = Resources.getSystem().getBoolean(this)
val Int.asDimen: Float @DimenRes get() = Resources.getSystem().getDimension(this)
val Int.asString: String @StringRes get() = Resources.getSystem().getString(this)
val Int.asColor: Int @ColorRes get() = Resources.getSystem().getColor(this)
val Int.asDrawable: Drawable @DrawableRes get() = Resources.getSystem().getDrawable(this)
val Int.asColorStateList: ColorStateList @ColorRes get() = Resources.getSystem().getColorStateList(this)
val Int.asDrawables: List<Drawable>
    @ArrayRes get() {
        val array = Resources.getSystem().obtainTypedArray(this)
        val list = mutableListOf<Drawable>()
        for (i in 0..array.length()-1) list.add(array.getDrawable(i))
        array.recycle()
        return list
    }
val Int.asColorStateLists: List<ColorStateList>
    @ArrayRes get() {
        val array = Resources.getSystem().obtainTypedArray(this)
        val list = mutableListOf<ColorStateList>()
        for (i in 0..array.length()-1) list.add(array.getColorStateList(i))
        array.recycle()
        return list
    }
