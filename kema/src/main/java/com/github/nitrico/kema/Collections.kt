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

infix fun <T> T.appendTo(list: List<T>) = list + listOf(this)
infix fun <T> T.prependTo(list: List<T>) = listOf(this) + list
