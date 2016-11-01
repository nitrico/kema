package com.github.nitrico.kema

import android.app.Activity
import android.app.Fragment
import android.support.v4.app.Fragment as SupportFragment

@Suppress("UNCHECKED_CAST")
fun <T> Activity.argument(key: String) = intent.extras.get(key) as T
fun <T> Activity.lazyArgument(key: String) = lazy { argument<T>(key) }

@Suppress("UNCHECKED_CAST")
fun <T> Fragment.argument(key: String) = arguments.get(key) as T
fun <T> Fragment.lazyArgument(key: String) = lazy { argument<T>(key) }

@Suppress("UNCHECKED_CAST")
fun <T> SupportFragment.argument(key: String) = arguments.get(key) as T
fun <T> SupportFragment.lazyArgument(key: String) = lazy { argument<T>(key) }
