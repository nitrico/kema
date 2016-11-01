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

val Int.asTwoDigits: String get() = toLong().asTwoDigits

val Long.asTwoDigits: String get() = String.format("%02d", this)

fun Int.toTimeString(withUnits: Boolean = false) = toLong().toTimeString(withUnits)

fun Long.toTimeString(withUnits: Boolean = false): String {
    val MINUTE: Long = 60
    val HOUR: Long = 3600
    return when {
        this < MINUTE -> {
            if (withUnits) "${asTwoDigits}s"
            else "$asTwoDigits"
        }
        this < HOUR -> {
            val minutes: Long = this / MINUTE
            val seconds: Long = this - minutes*MINUTE
            if (withUnits) "${minutes.asTwoDigits}m:${seconds.asTwoDigits}s"
            else "${minutes.asTwoDigits}:${seconds.asTwoDigits}"
        }
        else -> {
            val hours: Long = this / HOUR
            val minutes: Long = (this - hours*HOUR) / MINUTE
            val seconds: Long = this - hours*HOUR - minutes*MINUTE
            if (withUnits) "${hours}h:${minutes.asTwoDigits}m:${seconds.asTwoDigits}s"
            else "$hours:${minutes.asTwoDigits}:${seconds.asTwoDigits}"
        }
    }
}
