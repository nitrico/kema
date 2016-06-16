package com.github.nitrico.kema

fun constrain(min: Float, max: Float, v: Float): Float = Math.max(min, Math.min(max, v))

fun Double.format(decimals: Int): String = java.lang.String.format("%.${decimals}f", this)
fun Float.format(decimals: Int): String = java.lang.String.format("%.${decimals}f", this)

fun Float.toDistanceString(): String {
    val ms = this.toInt()
    if (ms < 2000) return "" +ms +" m"
    else if (ms < 10000) {
        val kms: Float = ms / 1000f
        return "" +kms.format(1) +" Km"
    }
    else {
        val kms = ms / 1000
        return "" +kms +" Km"
    }
}
