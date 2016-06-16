package com.github.nitrico.kema

import android.app.Activity
import android.support.v4.app.Fragment

inline fun <reified T> Activity.argument(key: String): T = intent.extras.get(key) as T
inline fun <reified T> Fragment.argument(key: String): T = arguments.get(key) as T

inline fun <reified T> Activity.lazyArgument(key: String): Lazy<T> = lazy { argument<T>(key) }
inline fun <reified T> Fragment.lazyArgument(key: String): Lazy<T> = lazy { argument<T>(key) }
