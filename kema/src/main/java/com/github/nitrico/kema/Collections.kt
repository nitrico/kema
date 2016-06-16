package com.github.nitrico.kema

fun <T> MutableCollection<T>.addIfNew(t: T) {
    if (!contains(t)) add(t)
}

fun <T> Collection<T>.doIfContained(t: T, func: T.() -> Unit): Boolean {
    if (contains(t)) {
        t.func()
        return true
    }
    return false
}
