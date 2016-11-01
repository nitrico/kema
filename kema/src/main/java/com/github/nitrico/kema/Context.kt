package com.github.nitrico.kema

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.util.TypedValue
import android.view.LayoutInflater

val Context.inflater: LayoutInflater get() = LayoutInflater.from(this)
val Context.res: Resources get() = resources

val Context.isNetworkAvailable: Boolean
    get() {
        val network = connectivityManager.activeNetworkInfo
        return network != null && network.isConnected
    }

fun Context.resolve(attrId: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attrId, typedValue, true)
    return typedValue.data
}

fun Context.share(text: String, caption: String = text) {
    val intent = Intent(Intent.ACTION_SEND).setType("text/plain").putExtra(Intent.EXTRA_TEXT, text)
    startActivity(Intent.createChooser(intent, caption))
}
