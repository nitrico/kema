package com.github.nitrico.kema

import android.content.SharedPreferences

inline fun SharedPreferences.edit(now: Boolean = false, func: SharedPreferences.Editor.() -> Unit) = edit().apply {
    func()
    if (now) commit() else apply()
}

fun <T> SharedPreferences.put(key: String, t: T) {
    when (t) {
        is Int -> edit().putInt(key, t)
        is Long -> edit().putLong(key, t)
        is Float -> edit().putFloat(key, t)
        is String -> edit().putString(key, t)
        is Boolean -> edit().putBoolean(key, t)
    }
}

fun SharedPreferences.put(key: String, value: Int) = edit().putInt(key, value)
fun SharedPreferences.put(key: String, value: Long) = edit().putLong(key, value)
fun SharedPreferences.put(key: String, value: Float) = edit().putFloat(key, value)
fun SharedPreferences.put(key: String, value: String) = edit().putString(key, value)
fun SharedPreferences.put(key: String, value: Boolean) = edit().putBoolean(key, value)
fun SharedPreferences.put(key: String, value: Set<String>) = edit().putStringSet(key, value)
