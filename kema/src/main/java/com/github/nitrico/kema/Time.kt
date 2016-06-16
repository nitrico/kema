package com.github.nitrico.kema

import java.util.*

private const val MINUTE = 60
private const val HOUR = 60*MINUTE
private const val DAY = 24*HOUR
private const val WEEK = 7*DAY
private const val MONTH = 30*DAY
private const val YEAR = 365*DAY

fun Long.toTimeAgo(): String {
    val now = Date().time
    val diff: Long = now - this
    val secs: Long = diff / 1000
    return when {
        secs < MINUTE -> "$secs s"
        secs < HOUR -> "${secs/MINUTE} m"
        secs < DAY -> "${secs/HOUR} h"
        secs < WEEK -> "${secs/DAY} d"
        secs < MONTH -> "${secs/WEEK} w"
        secs < YEAR -> "${secs/MONTH} M"
        else -> "${secs/YEAR} y"
    }
}

fun Long.toTwoDigitsString() = String.format("%02d", this)

fun Long.toTimeString(withUnits: Boolean = false): String {
    val MINUTE: Long = 60
    val HOUR: Long = 3600
    if (this < MINUTE) {
        if (withUnits) return "${this.toTwoDigitsString()}s"
        else return "${this.toTwoDigitsString()}"
    }
    else if (this < HOUR) {
        val minutes: Long = this / MINUTE
        val seconds: Long = this - (minutes * MINUTE)
        if (withUnits) return "${minutes.toTwoDigitsString()}m:${seconds.toTwoDigitsString()}s"
        else return "${minutes.toTwoDigitsString()}:${seconds.toTwoDigitsString()}"
    }
    else {
        val hours: Long = this / HOUR
        val minutes: Long = (this - hours*HOUR) / MINUTE
        val seconds: Long = this - hours*HOUR - minutes*MINUTE
        if (withUnits) return "${hours}h:${minutes.toTwoDigitsString()}m:${seconds.toTwoDigitsString()}s"
        else return "$hours:${minutes.toTwoDigitsString()}:${seconds.toTwoDigitsString()}"
    }
}
