package com.github.nitrico.kema

fun Float.constrain(min: Float, max: Float): Float = Math.max(min, Math.min(max, this))

fun Double.withDecimals(decimals: Int) = String.format("%.${decimals}f", this)
fun Float.withDecimals(decimals: Int) = String.format("%.${decimals}f", this)

val Float.asDistance: String
    get() = when {
        this < 2000 -> "${this.toInt()} m"
        this < 10000 -> "${(this / 1000f).withDecimals(1)} Km"
        else -> "${(this / 1000f).toInt()} Km"
    }
