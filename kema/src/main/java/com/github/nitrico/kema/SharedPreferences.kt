package com.github.nitrico.kema

import android.content.SharedPreferences

inline fun SharedPreferences.edit(
        now: Boolean = false,
        func: SharedPreferences.Editor.() -> Unit) = edit().apply {
    func()
    if (now) commit() else apply()
}

fun <T> SharedPreferences.put(tag: String, t: T) {
    when (t) {
        is Int -> edit().putInt(tag, t)
        is Long -> edit().putLong(tag, t)
        is Float -> edit().putFloat(tag, t)
        is String -> edit().putString(tag, t)
        is Boolean -> edit().putBoolean(tag, t)
    }
}

fun SharedPreferences.put(tag: String, value: Int) = edit().putInt(tag, value)
fun SharedPreferences.put(tag: String, value: Long) = edit().putLong(tag, value)
fun SharedPreferences.put(tag: String, value: Float) = edit().putFloat(tag, value)
fun SharedPreferences.put(tag: String, value: String) = edit().putString(tag, value)
fun SharedPreferences.put(tag: String, value: Boolean) = edit().putBoolean(tag, value)
fun SharedPreferences.put(tag: String, value: Set<String>) = edit().putStringSet(tag, value)
