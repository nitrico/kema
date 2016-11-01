package com.github.nitrico.kema

import android.content.res.Resources

// dp to pixels
val Int.dp: Int get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

// float dp to pixels
val Float.dp: Int get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

// integer to float
val Int.f: Float get() = toFloat()

// integer to double
val Int.d: Double get() = toDouble()

// float to integer
val Float.i: Int get() = toInt()

// double to integer
val Double.i: Int get() = toInt()
