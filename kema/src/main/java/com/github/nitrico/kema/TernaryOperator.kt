package com.github.nitrico.kema

class Ternary<T>(val expr: Boolean, val then: T) {
    operator fun div(elze: T): T = if (expr) then else elze
}

// val result = myExpression % "a" / "b"
operator fun <T> Boolean.mod(a: T): Ternary<T> = Ternary(this, a)
